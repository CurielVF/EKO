package mx.itesm.rmr;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class PantallaInfo extends Pantalla{

    private final Juego juego;

    private Texture texturaFondo;

    //MENU
    private Stage escenaMenu; //botones...

    public PantallaInfo(Juego juego) {
        this.juego=juego;
    }

    @Override
    public void show() {
        texturaFondo=new Texture("fondoIntro.jpg");

        crearMenu();


    }

    private void crearMenu() {
        escenaMenu=new Stage(vista);

        Boton botonInfo=new Boton("btnReturn.png","btnReturnP.png");
        botonInfo.setPosition(ANCHO/2-botonInfo.getWidth()/2,ALTO*0.115f);

        botonInfo.getBtn().addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                juego.setScreen(new PantallaMenu(juego));
            }
        });
        escenaMenu.addActor(botonInfo.getBtn());

        Gdx.input.setInputProcessor(escenaMenu);


    }

    @Override
    public void render(float delta) {
        borrarPantalla();
        batch.setProjectionMatrix(camara.combined);

        batch.begin();
        batch.draw(texturaFondo,0,0);
        batch.end();

        escenaMenu.draw();
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {
        texturaFondo.dispose();
    }


}
