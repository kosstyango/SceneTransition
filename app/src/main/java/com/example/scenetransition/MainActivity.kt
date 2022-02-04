package com.example.scenetransition

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.Scene
import android.transition.TransitionManager

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val scene1 = Scene.getSceneForLayout(findViewById(R.id.scene_root), R.layout.scene1,this)
        val scene2 = Scene.getSceneForLayout(findViewById(R.id.scene_root), R.layout.scene2, this)
        val transitionManager = TransitionManager()
        //Когда зашли на scene1, устанавливаем обработчик нажатия на кнопку, который запустит scene2
        scene1.setEnterAction {
            scene1.sceneRoot.button.setOnClickListener {
                transitionManager.transitionTo(scene2)
            }
        }
        //Аналогичный код
        scene2.setEnterAction {
            scene2.sceneRoot.button.setOnClickListener {
                transitionManager.transitionTo(scene1)
            }
        }
        //Запускаем scene1
        transitionManager.transitionTo(scene1)
    }
}