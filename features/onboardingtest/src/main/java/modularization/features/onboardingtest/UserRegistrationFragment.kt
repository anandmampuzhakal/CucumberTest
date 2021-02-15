package modularization.features.onboardingtest

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.nz.anand.mvvmlibrary.extension.viewDataBindingOf
import com.nz.anand.mvvmlibrary.extension.viewModelOf
import com.nz.anand.mvvmlibrary.mvvm.MVVMBaseFragment
import modularization.features.onboardingtest.databinding.FragmentUserRegistrationBinding
import modularization.features.onboardingtest.viewmodel.UserRegistrationViewModel


class UserRegistrationFragment : MVVMBaseFragment(R.layout.fragment_user_registration) {

    private val mViewModel: UserRegistrationViewModel by viewModelOf()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val db = viewDataBindingOf<FragmentUserRegistrationBinding>()
        db.vm = mViewModel

        db.buttonRegister.setOnClickListener {
           if(db.username.text.toString().isNotEmpty() && db.amount.tag.toString().isNotEmpty()) {
                activity?.intent?.putExtra("userName", db.username.text.toString())
                activity?.intent?.putExtra("numberToWords", db.amount.tag.toString())
                findNavController().navigate(R.id.action_user_registration_to_result_Fragment)
            }else{
                Toast.makeText(activity,getString(R.string.inputs_error),Toast.LENGTH_SHORT).show()
              }
        }

    }
  }