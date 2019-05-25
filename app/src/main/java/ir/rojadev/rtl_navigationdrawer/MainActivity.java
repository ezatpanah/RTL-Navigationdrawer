package ir.rojadev.rtl_navigationdrawer;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{

    public NavigationView navigationView;
    public DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        navigationView = findViewById(R.id.navigation);
        drawerLayout = findViewById(R.id.drawer);


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener()
        {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem)
            {
                int id = menuItem.getItemId();
                seletItemMenu(id);
                return true;
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.open_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        int id = item.getItemId();
        if (id == R.id.open_menu)
        {
            drawerLayout.openDrawer(Gravity.RIGHT);
        }
        return true;
    }

    @Override
    public void onBackPressed()
    {
        if (drawerLayout.isDrawerOpen(Gravity.RIGHT))
        {
            drawerLayout.closeDrawer(Gravity.RIGHT);
        }

    }

    public void seletItemMenu(int id_item)
    {
        switch (id_item)
        {
            case R.id.item_about:
                Toast.makeText(MainActivity.this, "شما بروی گزینه درباره ما کلیک کردید",
                        Toast.LENGTH_LONG
                ).show();
                break;
            case R.id.item_setting:
                Toast.makeText(MainActivity.this, "شما بروی گزینه تنظیمات کلیک کردید",
                        Toast.LENGTH_LONG
                ).show();
                break;


            case R.id.item_search:
                Toast.makeText(MainActivity.this, "شما بروی گزینه جستجو کلیک کردید",
                        Toast.LENGTH_LONG
                ).show();
                break;

            case R.id.item_contact:
                Toast.makeText(MainActivity.this, "شما بروی گزینه تماس با ما کلیک کردید",
                        Toast.LENGTH_LONG
                ).show();
                break;

            case R.id.item_fav:
                Toast.makeText(MainActivity.this, "شما بروی گزینه علاقه مندی ها کلیک " +
                        "کردید", Toast.LENGTH_LONG).show();
                break;

            case R.id.item_exit:
                finish();

        }

    }
}
