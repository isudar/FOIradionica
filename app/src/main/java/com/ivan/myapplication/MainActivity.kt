package com.ivan.myapplication

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast

import com.ivan.myapplication.models.InspiringPerson
import kotlinx.android.synthetic.main.activity_details.*
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : Activity(), View.OnClickListener {

    var Turing = InspiringPerson()
    var Bebidz = InspiringPerson()
    lateinit var Grace : InspiringPerson

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeData()
        initializeUI()
    }

    private fun initializeUI() {
        ivTuring.setOnClickListener(this)
        ivBebidz.setOnClickListener(this)
        ivGrace.setOnClickListener(this)

        tvTuring.text = Turing.bio
        ivTuring.setImageResource(Turing.profilePicute)
        tvBebidz.text = Bebidz.bio
        ivBebidz.setImageResource(Bebidz.profilePicute)
        tvGrace.text = Grace.bio
        ivGrace.setImageResource(Grace.profilePicute)
    }

    private fun initializeData(){
        Turing.name = resources.getString(R.string.turing_name)
        Turing.bio = resources.getString(R.string.turing)
        Turing.quote = resources.getString(R.string.qTuring)
        Turing.profilePicute = R.drawable.turing

        Bebidz.name = resources.getString(R.string.bebidz_name)
        Bebidz.bio = resources.getString(R.string.bebidz)
        Bebidz.quote = resources.getString(R.string.qBebidz)
        Bebidz.profilePicute = R.drawable.bebidz

        Grace = InspiringPerson(resources.getString(R.string.grace_name), resources.getString(R.string.grace),resources.getString(R.string.qGrace), R.drawable.grace )
    }

    override fun onClick(view: View) {

        when (view) {
            ivTuring -> displayToast(Turing.quote)


            ivBebidz -> displayToast(Bebidz.quote)


            ivGrace -> displayToast(Grace.quote)

            tvTuring -> { openDetailsFragment()}
            tvBebidz -> { openDetailsFragment()}
            tvGrace -> { openDetailsFragment()}
        }
    }

    //private fun openDetailsFragment(name : String, image: Int , descrption : String ) {

    private fun openDetailsFragment() {
       // val openDetails = Intent(this, DetailsActivity::class.java)
        //TODO POSLATI PARAMETRE U DETAILS SCREEN

        //startActivity(openDetails)

    }

    private fun displayToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}
