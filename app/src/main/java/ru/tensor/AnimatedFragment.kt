package ru.tensor

import android.os.Bundle
import android.transition.*
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class AnimatedFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_animated_scene1, container, false).also {
        it.findViewById<Button>(R.id.start_animation).setOnClickListener {
            animate()
        }
    }


    private fun animate() {
        val scene = Scene.getSceneForLayout(requireView() as ViewGroup, R.layout.fragment_animated_scene2, requireContext())
        TransitionManager.go(scene, TransitionSet().apply {
            duration = 400
            addTransition(Fade())
            addTransition(ChangeBounds())
        })
    }
}