package com.kamal.fragment.fragments

import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.islami.base.BaseFragment
import com.kamal.servers.R
import kotlinx.android.synthetic.main.fragment_server3.*

class FragmentServer3 : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_server3, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navigation_logo.setOnNavigationItemSelectedListener {
            if(it.itemId == R.id.navigation_Message)
            {
                showDialig(title = "Message Request",message = "You would like to chat with server?",
                posActionName = "Ok",posAction = DialogInterface.OnClickListener { dialog, which -> dialog.dismiss() }
                       ,negActionName = "Cancel",negAction = DialogInterface.OnClickListener { dialog, which ->
                    dialog.cancel()
                    dialog.dismiss() },
                isCancallable = false)
            }
            else if(it.itemId == R.id.navigation_Phone)
            {
                showBottomSheet()
            }
            else if(it.itemId == R.id.navigation_Video)
            {
                makeToast("Sorry video is not available now")
            }
            true
        }
    }

    private fun showBottomSheet() {
        val sheet = BottomSheetFragmentCall()
        sheet.show(childFragmentManager,"")
    }

    override fun onStart() {
        super.onStart()
        //dialogueFragment
        dialog?.let {
            val width = ViewGroup.LayoutParams.MATCH_PARENT
            val height = ViewGroup.LayoutParams.MATCH_PARENT
            it.window?.setLayout(width, height)
        }
    }
}