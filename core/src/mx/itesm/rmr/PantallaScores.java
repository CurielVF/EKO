package mx.itesm.rmr;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class PantallaScores extends Pantalla{

    private final Juego juego;

    private Texture texturaFondo;

    //MENU
    private Stage escenaMenu; //botones...

    public PantallaScores(Juego juego) {
        this.juego=juego;
    }

    @Override
    public void show() {
        texturaFondo=new Texture("fondoScores.jpg");

        crearMenu();


    }

    private void crearMenu() {
        escenaMenu=new Stage(vista);
        //Boton Scores
        Boton botonScores=new Boton("btnReturn.png","btnReturnP.png");
        botonScores.setPosition(ANCHO/2-botonScores.getWidth()/2,ALTO*0.115f);
        botonScores.getBtn().addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                juego.setScreen(new PantallaMenu(juego));
            }
        });
        escenaMenu.addActor(botonScores.getBtn());

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
