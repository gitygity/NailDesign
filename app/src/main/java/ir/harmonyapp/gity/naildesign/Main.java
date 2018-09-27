package ir.harmonyapp.gity.naildesign;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import uk.co.samuelwall.materialtaptargetprompt.MaterialTapTargetPrompt;
import uk.co.samuelwall.materialtaptargetprompt.extras.backgrounds.RectanglePromptBackground;
import uk.co.samuelwall.materialtaptargetprompt.extras.focals.RectanglePromptFocal;

public class Main extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    ImageView lak, health, favorite, about, design, exit, gallery1;
    SharedPreferences sharedPreferences;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        define();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_RTL);


        sharedPreferences = getSharedPreferences("GUIDE", MODE_PRIVATE);
        if (sharedPreferences.contains("state") && sharedPreferences.getInt("state", 0) == 1) {

        } else {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt("state", 1);
            editor.commit();

            new MaterialTapTargetPrompt.Builder(Main.this)

                    .setTarget(findViewById(R.id.b2_health))
                    .setPrimaryText("سلامت ناخن")
                    .setSecondaryText(" در این قسمت میتوانید اطلاعات مفیدی در مورد سلامت ناخن کسب کنید.")
                    .setPromptBackground(new RectanglePromptBackground())
                    .setPromptFocal(new RectanglePromptFocal())
                    .setPromptStateChangeListener(new MaterialTapTargetPrompt.PromptStateChangeListener() {
                        @Override
                        public void onPromptStateChanged(MaterialTapTargetPrompt prompt, int state) {
                            if (state == MaterialTapTargetPrompt.STATE_NON_FOCAL_PRESSED) {
                                new MaterialTapTargetPrompt.Builder(Main.this)
                                        .setTarget(findViewById(R.id.b1_lak))
                                        .setPrimaryText("لاک ناخن")

                                        .setSecondaryText("در این قسمت میتوانید اطلاعات مفیدی در مورد لاک ناخن کسب کنید. ")
                                        .setPromptBackground(new RectanglePromptBackground())
                                        .setPromptFocal(new RectanglePromptFocal())
                                        .setPromptStateChangeListener(new MaterialTapTargetPrompt.PromptStateChangeListener() {
                                            @Override
                                            public void onPromptStateChanged(MaterialTapTargetPrompt prompt, int state) {
                                                if (state == MaterialTapTargetPrompt.STATE_NON_FOCAL_PRESSED) {
                                                    new MaterialTapTargetPrompt.Builder(Main.this)
                                                            .setTarget(findViewById(R.id.b3_design))
                                                            .setPrimaryText("طراحی ناخن")

                                                            .setSecondaryText("در این قسمت میتوانید اطلاعات مفیدی در مورد طراحی ناخن، ابزار طراحی و متد های طراحی کسب کنید. ")
                                                            .setPromptBackground(new RectanglePromptBackground())
                                                            .setPromptFocal(new RectanglePromptFocal())
                                                            .setPromptStateChangeListener(new MaterialTapTargetPrompt.PromptStateChangeListener() {
                                                                @Override
                                                                public void onPromptStateChanged(MaterialTapTargetPrompt prompt, int state) {
                                                                    if (state == MaterialTapTargetPrompt.STATE_NON_FOCAL_PRESSED) {
                                                                        new MaterialTapTargetPrompt.Builder(Main.this)
                                                                                .setTarget(findViewById(R.id.b4_favorite))
                                                                                .setPrimaryText("علاقه مندی ها")

                                                                                .setSecondaryText("در این قسمت میتوانید لیست مطالب مورد علاقه خود را که در بخش های قبل به عنوان علاقه مندی انتخاب کرده اید مشاهده نمایید.")
                                                                                .setPromptBackground(new RectanglePromptBackground())
                                                                                .setPromptFocal(new RectanglePromptFocal())
                                                                                .setPromptStateChangeListener(new MaterialTapTargetPrompt.PromptStateChangeListener() {
                                                                                    @Override
                                                                                    public void onPromptStateChanged(MaterialTapTargetPrompt prompt, int state) {
                                                                                        if (state == MaterialTapTargetPrompt.STATE_NON_FOCAL_PRESSED) {
                                                                                            new MaterialTapTargetPrompt.Builder(Main.this)
                                                                                                    .setTarget(findViewById(R.id.b5_about))
                                                                                                    .setPrimaryText("درباره ما")
                                                                                                    .setPromptBackground(new RectanglePromptBackground())
                                                                                                    .setPromptFocal(new RectanglePromptFocal())
                                                                                                    .setSecondaryText(" در این قسمت میتوانید طریقه ارتباط و ارسال نظرات خود به ما و شرح کوتاهی از عملکرد برنامه را مشاهده نمایید.")
                                                                                                    .setPromptBackground(new RectanglePromptBackground())
                                                                                                    .setPromptFocal(new RectanglePromptFocal())
                                                                                                    .setPromptStateChangeListener(new MaterialTapTargetPrompt.PromptStateChangeListener() {
                                                                                                        @Override
                                                                                                        public void onPromptStateChanged(MaterialTapTargetPrompt prompt, int state) {
                                                                                                            if (state == MaterialTapTargetPrompt.STATE_NON_FOCAL_PRESSED) {
                                                                                                                new MaterialTapTargetPrompt.Builder(Main.this)
                                                                                                                        .setTarget(findViewById(R.id.gallerynail))
                                                                                                                        .setPrimaryText("گالری تصاویر طراحی ناخن")
                                                                                                                        .setPromptBackground(new RectanglePromptBackground())
                                                                                                                        .setPromptFocal(new RectanglePromptFocal())
                                                                                                                        .setSecondaryText("  در این قسمت میتوانید گالری تصاویری از انواع طراحی های ناخن که به صورت مرحله به مرحله طراحی شده اند را مشاهده نمایید.")
                                                                                                                        .setPromptBackground(new RectanglePromptBackground())
                                                                                                                        .setPromptFocal(new RectanglePromptFocal())
                                                                                                                        .setPromptStateChangeListener(new MaterialTapTargetPrompt.PromptStateChangeListener() {
                                                                                                                            @Override
                                                                                                                            public void onPromptStateChanged(MaterialTapTargetPrompt prompt, int state) {
                                                                                                                                if (state == MaterialTapTargetPrompt.STATE_NON_FOCAL_PRESSED) {


                                                                                                                                    new MaterialTapTargetPrompt.Builder(Main.this)
                                                                                                                                            .setTarget(findViewById(R.id.fab))
                                                                                                                                            .setPrimaryText("ایمیل")

                                                                                                                                            .setSecondaryText("  در این قسمت میتوانید به ارسال نظرات و پیشنهادات خود در مورد برنامه بپردازید.")

                                                                                                                                            .setPromptStateChangeListener(new MaterialTapTargetPrompt.PromptStateChangeListener() {
                                                                                                                                                @Override
                                                                                                                                                public void onPromptStateChanged(MaterialTapTargetPrompt prompt, int state) {
                                                                                                                                                    if (state == MaterialTapTargetPrompt.STATE_NON_FOCAL_PRESSED) {
                                                                                                                                                        new MaterialTapTargetPrompt.Builder(Main.this)
                                                                                                                                                                .setTarget(findViewById(R.id.b6_exit))
                                                                                                                                                                .setPrimaryText("خروج")
                                                                                                                                                                .setPromptBackground(new RectanglePromptBackground())
                                                                                                                                                                .setPromptFocal(new RectanglePromptFocal())
                                                                                                                                                                .setSecondaryText("  خروج از برنامه ... :(")
                                                                                                                                                                .setPromptBackground(new RectanglePromptBackground())
                                                                                                                                                                .setPromptFocal(new RectanglePromptFocal())
                                                                                                                                                                .setPromptStateChangeListener(new MaterialTapTargetPrompt.PromptStateChangeListener() {
                                                                                                                                                                    @Override
                                                                                                                                                                    public void onPromptStateChanged(MaterialTapTargetPrompt prompt, int state) {
                                                                                                                                                                        if (state == MaterialTapTargetPrompt.STATE_NON_FOCAL_PRESSED) {


                                                                                                                                                                        }
                                                                                                                                                                    }
                                                                                                                                                                })
                                                                                                                                                                .show();

                                                                                                                                                    }
                                                                                                                                                }
                                                                                                                                            })
                                                                                                                                            .show();


                                                                                                                                }
                                                                                                                            }
                                                                                                                        })
                                                                                                                        .show();

                                                                                                            }
                                                                                                        }
                                                                                                    })
                                                                                                    .show();

                                                                                        }
                                                                                    }
                                                                                })
                                                                                .show();

                                                                    }
                                                                }
                                                            })
                                                            .show();

                                                }
                                            }
                                        })
                                        .show();
                            }
                        }
                    })
                    .show();


        }


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//
//
                Snackbar.make(view, " ایمیل", Snackbar.LENGTH_LONG)
                        .setAction("ارسال نظرات و پیشنهادات", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {


                                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                                emailIntent.setData(Uri.parse("mailto:"));
                                emailIntent.setType("text/plain");
                                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"gity.ghasemi@gmail.com"});
                                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "نظرات و پیشنهادات/ اپلیکیشن طراحی ناخن");
                                emailIntent.putExtra(Intent.EXTRA_TEXT, "متن پیام");

                                startActivity(Intent.createChooser(emailIntent, "ارسال ایمیل..."));
                                finish();


                            }
                        }).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void define() {

        gallery1 = (ImageView) findViewById(R.id.gallerynail);
        gallery1.setOnClickListener(this);
        lak = (ImageView) findViewById(R.id.b1_lak);
        lak.setOnClickListener(this);
        health = (ImageView) findViewById(R.id.b2_health);
        health.setOnClickListener(this);
        favorite = (ImageView) findViewById(R.id.b4_favorite);
        favorite.setOnClickListener(this);
        about = (ImageView) findViewById(R.id.b5_about);
        about.setOnClickListener(this);
        design = (ImageView) findViewById(R.id.b3_design);
        design.setOnClickListener(this);
        exit = (ImageView) findViewById(R.id.b6_exit);
        exit.setOnClickListener(this);


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.lak) {
            Intent in = new Intent(Main.this, Lak.class);
            startActivity(in);

        } else if (id == R.id.health) {
            Intent in = new Intent(Main.this, Health.class);
            startActivity(in);

        } else if (id == R.id.favorite) {
            Intent in = new Intent(Main.this, Favorite.class);
            startActivity(in);

        } else if (id == R.id.design) {
            Intent in = new Intent(Main.this, Design.class);
            startActivity(in);

        } else if (id == R.id.about) {
            Intent in = new Intent(Main.this, AboutUs.class);
            startActivity(in);

        } else if (id == R.id.exit) {
            finish();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.b1_lak) {
            Intent in = new Intent(Main.this, Lak.class);
            startActivity(in);
        } else if (v.getId() == R.id.b2_health) {
            Intent in = new Intent(Main.this, Health.class);
            startActivity(in);
        } else if (v.getId() == R.id.b3_design) {
            Intent in = new Intent(Main.this, Design.class);
            startActivity(in);
        } else if (v.getId() == R.id.b4_favorite) {
            Intent in = new Intent(Main.this, Favorite.class);
            startActivity(in);
        } else if (v.getId() == R.id.b5_about) {
            Intent in = new Intent(Main.this, AboutUs.class);
            startActivity(in);
        } else if (v.getId() == R.id.b6_exit) {
            finish();
        } else if (v.getId() == R.id.gallerynail) {
            Intent in = new Intent(Main.this, GalleyNail.class);
            startActivity(in);

        }

    }
}
