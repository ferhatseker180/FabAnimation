package com.example.animasyonlufab

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var fabDurum = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fabPhoto.scaleX  = 0.0f
        fabPhoto.scaleY = 0.0f
        fabClock.scaleX = 0.0f
        fabClock.scaleY = 0.0f

        fabPhoto.setOnClickListener {

            Toast.makeText(applicationContext,"Resim Ekleme Tıklandı",Toast.LENGTH_SHORT).show()
        }
        fabClock.setOnClickListener {
            Toast.makeText(applicationContext,"Alarm Ekleme Tıklandı",Toast.LENGTH_SHORT).show()

        }
        fabAdd.setOnClickListener {
          //  Toast.makeText(applicationContext,"Ekleme Tuşuna Tıklandı",Toast.LENGTH_SHORT).show()
           if (fabDurum == true) {
// Fab görünürse...
               val r = ObjectAnimator.ofFloat(fabAdd,"rotation",360.0f,0.0f)
               val aX = ObjectAnimator.ofFloat(fabPhoto,"scaleX",1.0f,0.0f)
               val aY = ObjectAnimator.ofFloat(fabPhoto,"scaleY",1.0f,0.0f)
               val bX = ObjectAnimator.ofFloat(fabClock,"scaleX",1.0f,0.0f)
               val bY = ObjectAnimator.ofFloat(fabClock,"scaleY",1.0f,0.0f)

               val coklu = AnimatorSet().apply {
                   duration = 800
                   playTogether(aX,aY,bX,bY,r)
               }
               coklu.start()
               fabDurum = false


           }else {
               val r = ObjectAnimator.ofFloat(fabAdd,"rotation",0.0f,360.0f)
               val aX = ObjectAnimator.ofFloat(fabPhoto,"scaleX",0.0f,1.0f)
               val aY = ObjectAnimator.ofFloat(fabPhoto,"scaleY",0.0f,1.0f)
               val bX = ObjectAnimator.ofFloat(fabClock,"scaleX",0.0f,1.0f)
               val bY = ObjectAnimator.ofFloat(fabClock,"scaleY",0.0f,1.0f)

               val coklu = AnimatorSet().apply {
                   duration = 800
                   playTogether(aX,aY,bX,bY,r)
               }
               coklu.start()
               fabDurum = true

           }

        }
    }

}