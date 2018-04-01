package time.viva;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
ImageView im;
int count =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        im= (ImageView)findViewById(R.id.image);
        im.setImageResource(R.drawable.pupa);
        im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(count==0){
                    Animation myFadeInAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fadeout);
                    im.startAnimation(myFadeInAnimation);
                    for(int i = 0;i<3000;i++);
                    im.setImageResource(R.drawable.pupb);
                    im.setVisibility(View.INVISIBLE);
                    Animation myFadeInAnimation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fadein);
                    im.startAnimation(myFadeInAnimation1);
                    for(int i = 0;i<3000;i++);


                }


                if(count == 1){
                    Animation myFadeInAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fadeout);
                    im.startAnimation(myFadeInAnimation);
                    for(int i = 0;i<3000;i++);
                    im.setImageResource(R.drawable.pupa);
                    im.setVisibility(View.INVISIBLE);
                    Animation myFadeInAnimation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fadein);
                    im.startAnimation(myFadeInAnimation1);
                    for(int i = 0;i<3000;i++);
                    count =0;
                }
                    count =1;
            }
        });
//        Animation myFadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.fadein);
//        im.startAnimation(myFadeInAnimation);
    }
}
