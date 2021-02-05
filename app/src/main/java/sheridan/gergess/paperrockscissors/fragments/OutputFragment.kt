package sheridan.gergess.paperrockscissors.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import sheridan.gergess.paperrockscissors.Envelope
import sheridan.gergess.paperrockscissors.databinding.OutputFragmentBinding
import kotlin.random.Random

class OutputFragment : Fragment() {

    companion object {
        const val ENVELOPE = "envelope"
    }


    private var _binding: OutputFragmentBinding? = null
    private val binding get() = _binding!!

    private lateinit var envelope: Envelope

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = OutputFragmentBinding.inflate(inflater, container, false)
        envelope = arguments?.getSerializable(ENVELOPE) as Envelope
        showResult()
        return binding.root
    }

    private fun showResult() {

        val playerChoice = envelope.choice

        val random = Random.nextInt(0,3)

        val botChoice = when (random){
            0 -> "Rock"
            1 -> "Paper"
            2 -> "Scissor"
            else -> "None"
        }

        var winner = ""

        if(playerChoice === botChoice){
            winner = "tie"
        }else if ((playerChoice == "Rock" && botChoice == "Paper") || (playerChoice == "Paper" && botChoice == "Scissor") || (playerChoice == "Scissor" && botChoice == "Rock")){
            winner = "bot"
        }else if(botChoice != null && playerChoice != null){
            winner = "player"
        }

        binding.playerOutput.text = playerChoice
        binding.botOutput.text = botChoice

        binding.resultsOutput.text = winner

    }
}