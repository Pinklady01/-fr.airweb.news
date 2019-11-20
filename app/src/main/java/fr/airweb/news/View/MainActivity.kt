package fr.airweb.news.View
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import fr.airweb.news.Model.RetrofitClientInstance
import fr.airweb.news.Model.dto.NewsList
import fr.airweb.news.R
import fr.airweb.news.ViewModel.GetNewService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val service = RetrofitClientInstance.retrofitInstance?.create(GetNewService::class.java)
        val call = service?.getAllNews()
        call?.enqueue(object : Callback <NewsList>{
            override fun onFailure(call: Call<NewsList>, t: Throwable) {
                Log.v("erreur",t.message,t)//To change body of created functions use File | Settings | File Templates.
                Toast.makeText(applicationContext,"Error reading JSON",Toast.LENGTH_LONG).show()
                }

            override fun onResponse(call: Call<NewsList>, response: Response<NewsList>) {
                val body = response?.body()
                val news = body?.news

            }

        })

    }


}