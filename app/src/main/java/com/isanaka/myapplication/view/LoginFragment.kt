package com.isanaka.myapplication.view


import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AlertDialog
import android.text.method.LinkMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.isanaka.myapplication.R
import com.isanaka.myapplication.data.model.LoginDetails
import com.isanaka.myapplication.utils.SpannableHelper
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_login.*
import javax.inject.Inject










/**
 * A simple [Fragment] subclass.
 *
 */
class LoginFragment : DaggerFragment(), LoginContract.View {


    @Inject
    lateinit var presenter: LoginContract.Presenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        presenter.attachView(this)
    }

    override fun onResume() {
        super.onResume()
        forgotPassword.apply {
            text = SpannableHelper.buildFormattedText(
                "Forgot password? Tap here to recover it",
                "Tap here", resources.getColor(android.R.color.tab_indicator_text)
            )
            movementMethod = LinkMovementMethod.getInstance()
        }

        button.setOnClickListener {
            showProgress()
            presenter.onLogin(
                LoginDetails(
                    userName.text.toString(),
                    password.text.toString()
                )
            )
        }

    }

    override fun onLoginSuccessful(message: String) {
        hideProgress()
        showDialog("Success", message)
    }

    override fun onLoginFailed(error: String) {
        hideProgress()
        showDialog("Error", error)
    }

    override fun showProgress() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progressBar.visibility = View.GONE
    }

    private fun showDialog(title: String, message: String) {
        val builder = AlertDialog.Builder(context!!, R.style.MyDialogTheme)
        builder.setTitle(title)
            .setMessage(message)
            .setCancelable(false)

        val alert = builder.create()

        alert.setButton(DialogInterface.BUTTON_POSITIVE, "Ok"
        ) { _, _ -> alert.dismiss() }

        alert.show()
    }


}
