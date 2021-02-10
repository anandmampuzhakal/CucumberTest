package modularization.features.dashboard

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_dashboard.*

class DashboardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        bottomNavigation.setOnNavigationItemSelectedListener(::tabSelected)
        showFragment(TestStatusFragment())
    }

    private fun tabSelected(tab: MenuItem): Boolean {
        when (tab.itemId) {
            R.id.action_about_me-> showFragment(AboutMeFragment())
            R.id.action_item -> showFragment(TestStatusFragment())
            R.id.action_sharing -> showFragment(SocialFragment())
        }
        return false
    }

    private fun showFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.container, fragment).commit()
    }
}
