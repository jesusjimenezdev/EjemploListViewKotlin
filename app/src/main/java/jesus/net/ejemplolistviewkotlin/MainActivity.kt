package jesus.net.ejemplolistviewkotlin

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.list_item_coche.view.*

class MainActivity(var adapter: CochesAdapter? = null) : AppCompatActivity() {

    var listaCoches = ArrayList<Coche>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listaCoches.add(Coche(R.drawable.bowser, "Bowser", "Coche del malo", 1000, false))
        listaCoches.add(Coche(R.drawable.buddy, "Buddy", "Coche del bueno", 2000, true))
        listaCoches.add(Coche(R.drawable.camaro, "Camaro", "Coche del malo", 1000, false))
        listaCoches.add(Coche(R.drawable.charger, "Charger", "Coche del bueno", 2000, true))
        listaCoches.add(Coche(R.drawable.furyshark, "FuryShark", "Coche del malo", 1000, false))
        listaCoches.add(Coche(R.drawable.mariosm, "Mario", "Coche del bueno", 2000, true))
        listaCoches.add(Coche(R.drawable.toadsm, "Toad", "Coche del malo", 1000, false))
        listaCoches.add(Coche(R.drawable.yoshism, "Yoshi", "Coche del bueno", 2000, true))
        listaCoches.add(Coche(R.drawable.bowser, "Bowser", "Coche del malo", 1000, false))
        listaCoches.add(Coche(R.drawable.buddy, "Buddy", "Coche del bueno", 2000, true))
        listaCoches.add(Coche(R.drawable.camaro, "Camaro", "Coche del malo", 1000, false))
        listaCoches.add(Coche(R.drawable.charger, "Charger", "Coche del bueno", 2000, true))
        listaCoches.add(Coche(R.drawable.furyshark, "FuryShark", "Coche del malo", 1000, false))
        listaCoches.add(Coche(R.drawable.mariosm, "Mario", "Coche del bueno", 2000, true))
        listaCoches.add(Coche(R.drawable.toadsm, "Toad", "Coche del malo", 1000, false))
        listaCoches.add(Coche(R.drawable.yoshism, "Yoshi", "Coche del bueno", 2000, true))

        adapter = CochesAdapter(this,listaCoches)
        lista.adapter = adapter
    }

    class CochesAdapter(contexto: Context, var listaDeCoches: ArrayList<Coche>): BaseAdapter() {

        var contexto: Context = contexto

        override fun getItem(index: Int): Any {
            return listaDeCoches[index]
        }

        override fun getItemId(index: Int): Long {
            return index.toLong()
        }

        override fun getCount(): Int {
            return listaDeCoches.count()
        }

        override fun getView(index: Int, view: View?, viewGroup: ViewGroup?): View {
            val coche = listaDeCoches[index]
            var inflater = contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var miVista = inflater.inflate(R.layout.list_item_coche, null)
            miVista.imageView.setImageResource(coche.imagen!!)
            miVista.textViewTitulo.text = coche.titulo!!
            miVista.textViewDescripcion.text = coche.descripcion!!
            miVista.textViewPrecio.text = coche.precio!!.toString()
            miVista.imageView.setOnClickListener {
                val intent = Intent(contexto, DetalleActivity::class.java)
                intent.putExtra("imagen", coche.imagen!!)
                contexto.startActivity(intent)
            }

            return miVista
        }
    }
}
