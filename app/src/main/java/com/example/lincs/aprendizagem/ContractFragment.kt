package com.example.lincs.aprendizagem

import android.content.Context
import android.os.Bundle
import android.preference.PreferenceManager
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.heinrichreimersoftware.materialintro.app.SlideFragment
import kotlinx.android.synthetic.main.fragment_contract.*


/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [ContractFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [ContractFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class ContractFragment : SlideFragment() {

    // TODO: Rename and change types of parameters
    //    private var param2: String? = null
    //    private var listener: OnFragmentInteractionListener? = null
    private fun ContractFragment() {
        // Required empty public constructor
    }



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment



               return inflater.inflate(R.layout.fragment_contract, container, false)
    }

    override fun canGoForward(): Boolean {
        var termo = checkBox.isChecked
        if (termo) PreferenceManager.getDefaultSharedPreferences(activity).edit()
                .putBoolean("CheckBoxTerm", true)
                .apply()
        Log.i("checked",termo.toString())
        return termo
    }

//    // TODO: Rename method, update argument and hook method into UI event
//    fun onButtonPressed(uri: Uri) {
//        listener?.onFragmentInteraction(uri)
//    }
//
//    override fun onAttach(context: Context) {
//        super.onAttach(context)
//        if (context is OnFragmentInteractionListener) {
//            listener = context
//        } else {
//            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
//        }
//    }
//
//    override fun onDetach() {
//        super.onDetach()
//        listener = null
//    }
//
//    /**
//     * This interface must be implemented by activities that contain this
//     * fragment to allow an interaction in this fragment to be communicated
//     * to the activity and potentially other fragments contained in that
//     * activity.
//     *
//     *
//     * See the Android Training lesson [Communicating with Other Fragments]
//     * (http://developer.android.com/training/basics/fragments/communicating.html)
//     * for more information.
//     */
//    interface OnFragmentInteractionListener {
//        // TODO: Update argument type and name
//        fun onFragmentInteraction(uri: Uri)
//    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ContractFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(): ContractFragment {
            return com.example.lincs.aprendizagem.ContractFragment()}
    }
}
