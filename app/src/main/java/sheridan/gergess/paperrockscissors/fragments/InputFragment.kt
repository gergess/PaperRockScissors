package sheridan.gergess.paperrockscissors.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import sheridan.gergess.paperrockscissors.Envelope
import sheridan.gergess.paperrockscissors.R
import sheridan.gergess.paperrockscissors.databinding.InputFragmentBinding
import sheridan.gergess.paperrockscissors.fragments.OutputFragment.Companion.ENVELOPE

class InputFragment : Fragment() {

    private var _binding: InputFragmentBinding? = null
    private val binding get() = _binding!!

    private lateinit var navController: NavController

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = InputFragmentBinding.inflate(inflater, container, false)

        binding.playButton.setOnClickListener{onPlay()}

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = findNavController()
    }

    private fun onPlay() {

        val choice = when (binding.choiceGroup.checkedRadioButtonId){
            R.id.rock_button -> "Rock"
            R.id.paper_button -> "Paper"
            R.id.scissor_button -> "Scissor"
            else -> "None"
        }

        val arguments = Bundle()
        arguments.putSerializable(ENVELOPE, Envelope(choice))
        navController.navigate(R.id.action_input_to_output, arguments)
    }
}