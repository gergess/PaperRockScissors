package sheridan.gergess.paperrockscissors.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import sheridan.gergess.paperrockscissors.Envelope
import sheridan.gergess.paperrockscissors.R
import sheridan.gergess.paperrockscissors.databinding.OutputFragmentBinding

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.backButton.setOnClickListener {
            findNavController().navigate(R.id.action_output_to_input)
        }
    }


    private fun showResult() {

        val playerChoice = envelope.playerChoice
        val botChoice = envelope.botChoice

        var winner = ""

        if(playerChoice === botChoice){
            winner = "Tie, Keep it up!"
        }else if ((playerChoice == "Rock" && botChoice == "Paper") || (playerChoice == "Paper" && botChoice == "Scissor") || (playerChoice == "Scissor" && botChoice == "Rock")){
            winner = "Bot, Good luck next time!"
        }else if(botChoice != null && playerChoice != null){
            winner = "You, Yaaay Congrats"
        }

        binding.playerOutput.text = playerChoice
        binding.botOutput.text = botChoice

        binding.resultsOutput.text = winner

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}