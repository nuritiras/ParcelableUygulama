package tr.com.nuritiras.parcelableuygulama

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import tr.com.nuritiras.parcelableuygulama.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        enableEdgeToEdge()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun onClickOnayla(view: View) {
        val adiSoyadi = binding.editTextIsim.text.toString()
        val telefonNo = binding.editTextPhone.text.toString()
        val eMail = binding.editTextEposta.text.toString()
        val kisi = Bilgiler(adiSoyadi, telefonNo, eMail)
        val intent = Intent(this, DetayActivity::class.java)
        intent.putExtra("bilgi", kisi)
        startActivity(intent)
    }

}