package modularization.features.onboardingtest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import modularization.libraries.actions.Actions


class ResultFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_avatar, container, false)

        view.findViewById<TextView>(R.id.name_value_textView).text =
            activity?.intent?.getStringExtra("userName")
        view.findViewById<TextView>(R.id.numbers_in_words_value_textView).text =
            activity?.intent?.getStringExtra("numberToWords")
        view.findViewById<Button>(R.id.button_login_toapp).setOnClickListener {
            activity!!.startActivity(Actions.openDashBoardIntent(context!!, "fakeuser"))
        }
        return view
    }

}