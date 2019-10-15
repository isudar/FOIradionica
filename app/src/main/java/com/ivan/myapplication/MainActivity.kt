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

        tvTuring.setOnClickListener(this)
        tvBebidz.setOnClickListener(this)

        tvTuring.text = Turing.bio
        ivTuring.setImageResource(Turing.profilePicute)
        tvBebidz.text = Bebidz.bio
        ivBebidz.setImageResource(Bebidz.profilePicute)
        tvGrace.text = Grace.bio
        ivGrace.setImageResource(Grace.profilePicute)
    }

    private fun initializeData(){
        Turing.bio = resources.getString(R.string.turing)
        Turing.quote = resources.getString(R.string.qTuring)
        Turing.profilePicute = R.drawable.turing

        Bebidz.bio = resources.getString(R.string.bebidz)
        Bebidz.quote = resources.getString(R.string.qBebidz)
        Bebidz.profilePicute = R.drawable.bebidz

        Grace = InspiringPerson(resources.getString(R.string.grace),resources.getString(R.string.qGrace), R.drawable.grace )
    }

    override fun onClick(view: View) {

        when (view) {
            ivTuring -> {
                this.displayToast(Turing.quote)
            }

            ivBebidz -> {
                this.displayToast(Bebidz.quote)
            }

            ivGrace -> this.displayToast(Grace.quote)

            tvTuring -> { openDetailsFragment()}
            tvBebidz -> { openDetailsFragment()}
            tvGrace -> { openDetailsFragment()}
        }
    }

    private fun openDetailsFragment(personTag : String = EMPTY_STRING) {
        val openDetails = Intent(this, DetailsActivity::class.java)
        // TODO send userParams
        startActivity(openDetails)

    }

    private fun displayToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}
