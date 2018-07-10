package jesus.net.ejemplolistviewkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detalle.*

class DetalleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle)

        val bundle = intent.extras
        imageViewCoche.setImageResource(bundle.getInt("imagen"))
    }
}
