package com.ajinkyad.fragmentlifecycle.fragments

import android.app.*
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.support.v4.app.NotificationCompat
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ajinkyad.fragmentlifecycle.R


open class ParentFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        logEvent("onCreate")
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)
        logEvent("onCreateView")
        return view

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        logEvent("onActivityCreated")
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        logEvent("onAttach")
    }

    override fun onAttachFragment(childFragment: Fragment) {
        super.onAttachFragment(childFragment)
        logEvent("onAttachFragment")
    }

    override fun onAttach(activity: Activity) {
        super.onAttach(activity)
        logEvent("onAttach")
    }

    override fun onDestroy() {
        super.onDestroy()
        logEvent("onDestroy")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        logEvent("onDestroyView")
    }

    override fun onDetach() {
        super.onDetach()
        logEvent("onDetach")
    }

    override fun onPause() {
        super.onPause()
        logEvent("onPause")
    }

    override fun onStart() {
        super.onStart()
        logEvent("onStart")
    }

    override fun onStop() {
        super.onStop()
        logEvent("onStop")
    }

    override fun onResume() {
        super.onResume()
        logEvent("onResume")
    }

    /**
     * This function is used to fire the local Notification
     */
    private fun logEvent(methodName: String) {

        //The Current Activity Name
        val activityName = this.javaClass.simpleName
        Log.e(activityName, methodName)

        // There are hardcoding only for show it's just strings
        val name = "package_channel"
        val id = "channel_id" // The user-visible name of the channel.
        val description = "channel_description" // The user-visible description of the channel.

        val builder: NotificationCompat.Builder

        //To Trigger the local notification to the User
        val notificationManager = activity.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val importance = NotificationManager.IMPORTANCE_HIGH
            var mChannel = notificationManager.getNotificationChannel(id)
            if (mChannel == null) {
                mChannel = NotificationChannel(id, name, importance)
                mChannel.description = description
                notificationManager.createNotificationChannel(mChannel)
            }
            builder = NotificationCompat.Builder(activity, id)

            builder.setContentTitle(activityName)  // required
                    .setSmallIcon(R.drawable.ic_launcher_background)
                    .setContentTitle(activityName)
                    .setContentText(methodName)
                    .setDefaults(Notification.DEFAULT_ALL)
        } else {

            builder = NotificationCompat.Builder(activity)

            builder.setSmallIcon(R.drawable.ic_launcher_background)
                    .setContentTitle(activityName)
                    .setContentText(methodName)
                    .setDefaults(Notification.DEFAULT_ALL)
        }

        val notification = builder.build()
        //Trigger the notification if the notificationManager object is created successfully
        notificationManager.notify(System.currentTimeMillis().toInt(), notification)

    }
}

