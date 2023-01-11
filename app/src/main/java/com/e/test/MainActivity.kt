package com.e.test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private var listofID = listOf<Leagues>()
    private var  leagueadapter= LeagueAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       recyclerView = findViewById<RecyclerView>(R.id.recyclerview).apply {
            adapter=leagueadapter
            layoutManager=LinearLayoutManager(context)}
            leagueadapter.onItemClickListener={
            navigateToLeague(it.strLeagueAlternate)}
        getLeagues()
            }

    private fun navigateToLeague(liga: String) {
        val intent= Intent(this,League::class.java)
        intent.putExtra("dato",liga)
        startActivity(intent)

    }









    private fun getLeagues() {
    CoroutineScope(Dispatchers.IO).launch {
        val call= getRetrofit().create(ApiService::class.java).getLeagues()
        val response=call.body()
        runOnUiThread{
            if (call.isSuccessful){
                response?.apply {listofID= this.leagues }
                leagueadapter.submitList(listofID)
            }
        }



}
}


    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    companion object{
        val BASE_URL="https://www.thesportsdb.com/api/"
    }

}
