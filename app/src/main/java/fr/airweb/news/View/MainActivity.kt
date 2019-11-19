
import android.os.Bundle
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import fr.airweb.news.Model.RetrofitClientInstance
import fr.airweb.news.R
import fr.airweb.news.ViewModel.GetNewService

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        RetrofitClientInstance.retrofitInstance?.create(GetNewService::class.java)
    }


}