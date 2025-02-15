package com.galleryapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private DatabaseHelper dbHelper;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Database
        dbHelper = new DatabaseHelper(this);
        dbHelper.onCreate(dbHelper.getWritableDatabase());
        addPaintingsToDatabase();
    }

    private void addPaintingsToDatabase() {
        // Blue Period (1901–1904)
        dbHelper.insertPainting(new Painting(R.drawable.self_portrait, "Self Portrait", "Pablo Picasso", "1901", "Like El Greco and Vincent van Gogh, his illustrious predecessors in the genre, Picasso seems to have had a predilection for the self-portrait, where the external image of the man becomes infused with the subjective projection of the artist; throughout his long career he painted various likenesses of himself that reveal his progress in life and art. This Self-Portrait, painted during his second stay in Paris in the winter of 1901, was the end of a series and marked the beginning of the Blue Period. He returned to Barcelona in January 1902.", "Blue Period"));
        dbHelper.insertPainting(new Painting(R.drawable.blue_nude, "Blue Nude", "Pablo Picasso", "1902", "Blue Nude is one of Pablo Picasso's master piece in his early years. It was painted in 1902 and after one of his close friend tragically died, he mourned over it for a long time and was in a depressive mode. It is one of Picasso's paintings during his blue period and has without a doubt proved Picasso's talent on highlighting the deepest emotions while using only one color to effectively express it.", "Blue Period"));
        dbHelper.insertPainting(new Painting(R.drawable.the_old_guitarist, "The Old Guitarist", "Pablo Picasso", "1903", "The Old Guitarist was painted in 1903, just after the suicide death of Picasso's close friend, Casagemas. During this time, the artist was sympathetic to the plight of the downtrodden and painted many canvases depicting the miseries of the poor, the ill, and those cast out of society. He too knew what it was like to be impoverished, having been nearly penniless during all of 1902. This work was created in Madrid, and the distorted style (note that the upper torso of the guitarist seems to be reclining, while the bottom half appears to be sitting cross-legged) is reminiscent of the works of El Greco.", "Blue Period"));

        // Rose Period (1904–1906)
        dbHelper.insertPainting(new Painting(R.drawable.boy_with_pipe, "Garçon à la pipe (Boy with a Pipe)", "Pablo Picasso", "1905", "Garçon à la pipe was painted in 1905 when Picasso was 24 years old, during his Rose Period, soon after he settled in the Montmartre section of Paris, France. The oil on canvas painting depicts a Parisian boy holding a pipe in his left hand and wearing a garland or wreath of flowers.\n" +
                "\n" +
                "Early preparations of this work involved positioning the boy in all types of poses that involved standing, sitting or leaning against the wall. After much repositioning of the model, Picasso decided to go with the boy sitting down. Next was how to position the arm, where much time was also spent on the height and angle.", "Rose Period"));
        dbHelper.insertPainting(new Painting(R.drawable.boy_leading_a_horse, "Boy Leading a Horse", "Pablo Picasso", "1906", "Boy Leading a Horse is yet another masterpiece critics praise without trying to explain. Either they believe it has no meaning or that explaining it is impossible. That is no reason not to try. The more difficult an image is to interpret, the more you will experience aesthetic satisfaction when you do start to understand it. Richardson searched for Picasso's sources but gave up, calling the picture \"derivative.\" The painting, though, must mean something; all masterpieces do and it is our job to figure them out. Sources, as always, are key. The two figures - horse and boy - first appeared as a sketch for a much larger masterpiece that was never finished.", "Rose Period"));

        // Cubism (1907–1917)
        dbHelper.insertPainting(new Painting(R.drawable.girl_with_mandolin, "Girl with Mandolin", "Pablo Picasso", "1910", "By the winter of 1909/10 Picasso's pictorial language had already become increasingly hard to decipher. He was steadily divesting his paintings of mere likeness, not that this was synonymous with a progressive elimination of the subject: his paintings were becoming more abstract but not entirely so.\n" +
                "\n" +
                "In 1910 Picasso and Fernande Olivier spent a summer vacation in Cadaques, and this was where Woman with Mandolin originated. Having emerged from an Early Cubist phase which seemed, in part, expressive, Picasso was now in the throes of Analytical Cubism, a period during which he invested surface ornament with intrinsic value. In this picture, the characteristic fragmentation of form is carried to almost unrecognizable lengths. Only the mandolin is comparatively easy to identify in the lower reaches of the composition.' Both the outlines of the figure and its internal drawing have been broken down into interpenetrative geometrical elements. The coloration is dominated by brown tones paling to beige. Blue-grey accents, often directly juxtaposed with dark, structural lines, imbue the painting with facet-like plasticity.", "Cubism"));
        dbHelper.insertPainting(new Painting(R.drawable.portrait_of_ambroise_vollard, "Portrait of Ambroise Vollard", "Pablo Picasso", "1910", "Ambroise Vollard (1867-1939) was one of the great art dealers of the 20th century. He championed Paul Cezanne, Van Gogh, Renoir, Gauguin and Henri Matisse. He promoted Picasso's blue and rose periods, but he was careful about cubism. When Picasso later returned to a figuration informed by cubist richness and surrealist eroticism, they collaborated on one of Picasso's greatest achievements: his lubricious, mytho-erotic Vollard Suite, 100 engraved plates completed in 1937, culminating in emotional portraits of Vollard, who was to die two years later in a car crash.", "Cubism"));
        dbHelper.insertPainting(new Painting(R.drawable.ma_jolie, "Ma Jolie", "Pablo Picasso", "1911-1912", "Ma Jolie (My pretty girl) was the refrain of a popular song performed at a Parisian music hall Picasso frequented. The artist suggests this musical association by situating a treble clef and music staff near the bold, stenciled letters. Ma Jolie was also Picasso's nickname for his lover Marcelle Humbert, whose figure he loosely built using the signature shifting planes of Analytic Cubism.", "Cubism"));
        dbHelper.insertPainting(new Painting(R.drawable.guitar, "Guitar", "Pablo Picasso", "1914", "To create Guitar Picasso made a radical leap from the sculptural tradition of modeling (carving or molding) to a new technique of assemblage. He created a first version of Guitar from cardboard in 1912, then later remade the work in sheet metal; the modern ordinariness of both of these materials is very different from traditional sculptural materials such as bronze, wood, and marble. The planes of the sheet-metal construction engage in a play of substance and void in which volume is suggested, not depicted. In a dramatic demonstration of the flexible way visual forms can be read in context, the guitar's sound hole, which normally recedes from the instrument's smooth surface, here projects outward into space.", "Cubism"));

        // Classicism & Surrealism (1917–1937)
        dbHelper.insertPainting(new Painting(R.drawable.artist_and_his_model, "Artist and His Model", "Pablo Picasso", "1926", "In this painting, Artist and His Model, Picasso expressed the complicated connections between the painter and his model. It is painted in grey and while and this painting is the starting point for a long series with the thematic style. In this style, the figures of the subjects are build upon a network of intertwining curved lines. This painting, together with another one, The Dressmaker's Workshop, is the contemporary style with large monochromatic grey composition. The pattern of rounded forms is symbolic for the style called \"Curvilinear Cubism\".", "Classicism & Surrealism"));
        dbHelper.insertPainting(new Painting(R.drawable.crucifixion, "Crucifixion", "Pablo Picasso", "1930", "In this work, Picasso returns to his fascination with the 'life in death' paradox, encapsulated perfectly by the Western world's foremost symbol: the Crucifixion. The whole notion of rebirth and transformation has fascinated artists for centuries, as they see themselves as actively participating in an alchemical process while recreating life in their chosen medium.", "Classicism & Surrealism"));
        dbHelper.insertPainting(new Painting(R.drawable.figures_at_the_seaside, "Figure At The Seaside", "Pablo Picasso", "1931", "A series of bizarre erotic beach scenes, including The Kiss, was painted in the summer of 1931 at Picasso's French Riviera vacation resort, Juan-les-Pins. Said to be inspired by the 50-year-old painter's liaison with 19-year-old model, Marie-Therese Walter, the grotesque nature of the depicted forms reduces this moment of intimate contact to a level of crudity, probably more representative of his deteriorating relationship with his wife, Olga.", "Classicism & Surrealism"));
        dbHelper.insertPainting(new Painting(R.drawable.girl_before_a_mirror, "Girl Before A Mirror", "Pablo Picasso", "1932", "Girl Before Mirror was painted in March 1932. It was produced in the style Picasso was using at the time and evoked an image of Vanity such as had been utilized in art in earlier eras, though Picasso shifts the emphasis and creates a very different view of the image. The work is considered in terms of the erotic in Picasso's art, and critics in different periods have offered their assessments of the work to show a wide range of reactions.", "Classicism & Surrealism"));
        dbHelper.insertPainting(new Painting(R.drawable.bather_with_beach_ball, "Bather with Beach Ball", "Pablo Picasso", "1932", "Picasso is very good at grasping and exploiting any expressive possibility in any kind of earlier art. This is revealed with his own invention and Braque's, Cubism, initially posed a problem in this respect. In his paintings, faces are distorted as puzzle-like compositions and most of the features are lost. It took a while for Picasso to realize that Cubism could actually be deeply expressive: that the disconnection and rearrangement of parts of a person's appearance opened up vast new emotional possibilities for portraiture.", "Classicism & Surrealism"));
        dbHelper.insertPainting(new Painting(R.drawable.bull_fight, "Bullfight: Death of the Toreador", "Pablo Picasso", "1933", "Picasso's recent color experiments burst onto the canvas in full technicolor glory as he returns to his favorite them and personal passion: the bullfight. In later life he admitted that he often painted bullfights, traditionally held of Sundays, when unable to attend. This work was completed at Boisgeloup, the chateau 40 miles north-west of Paris, which Picasso, now fabulously wealthy, bought in 1930.", "Classicism & Surrealism"));
        dbHelper.insertPainting(new Painting(R.drawable.guernica, "Guernica", "Pablo Picasso", "1937", "Probably Picasso's most famous work, Guernica is certainly his most powerful political statement, painted as an immediate reaction to the Nazi's devastating casual bombing practice on the Basque town of Guernica during the Spanish Civil War.", "Classicism & Surrealism"));

        // Later Works (1937–1973)
        dbHelper.insertPainting(new Painting(R.drawable.portrait_of_sabartes, "Portrait of Sabartes", "Pablo Picasso", "1939", "This humorous portrait of Picasso's life-long Spanish friend, secretary and chief legend-monger is a wonderful joke. In 1938, Jaime Sabartes asked Picasso to draw him as a sixteenth-century royal courtier; those original drawings were eventually turned into this oil, painted at Royan. Portraying Sabartes as a Spanish courtier to Philip II is amusing as this was the role he played in the court of Picasso; that of the loyal servant following his master from Paris to Antibes to Royan. Although Sabartes was often represented by critics as a pathetically faithful dog, Picasso no doubt respected and returned his loyalty - albeit in his own fashion.", "Later Works"));
        dbHelper.insertPainting(new Painting(R.drawable.joie_de_vivre, "Joie De Vivire", "Pablo Picasso", "1946 ", "This work, obviously a parody of Henri Matisse's celebrated work Bonheur de Vivre (1905-06), is often read as a celebration of peace. Henri Matisse lyrical work features nubile girls dancing and playing pipes in an idyllic setting as long, sensual curvaceous lines flow through the composition. Picasso's copy is more overtly mythological, featuring with pipe-playing fauns and dancing creatures. However, he captures Matisses's lyricism in the extended swirling lines of the figures, whose forms appear to grow organically like flowers moving upwards towards the Mediterranean sun.", "Later Works"));
        dbHelper.insertPainting(new Painting(R.drawable.massacre_in_korea, "Massacre in Korea", "Pablo Picasso", "1951 ", "Massacre in Korea is a 1951 expressionistic painting by Pablo Picasso which is seen as a criticism of American intervention in the Korean War. It depicts the 1950 Sinchon Massacre, an act of mass killing carried out by North Koreans, South Koreans, and American forces in the town of Sinchon located in South Hwanghae Province, North Korea. Although the actual cause of the murders in Sinchon is in question, Massacre in Korea appears to depict them as civilians being killed by anti-Communist forces. The art critic Kirsten Hoving Keen says that it is \"inspired by reports of American atrocities\" and considers it one of Picasso's communist works. Picasso's work is drawn from Francisco Goya's painting The Third of May 1808, which shows Napoleon's soldiers executing Spanish civilians under the orders of Joachim Murat.", "Later Works"));
    }

    @Override
    protected void onDestroy() {
        dbHelper.close();
        super.onDestroy();
    }

    public void onCategoryClick(View view) {
        Intent intent = new Intent(this, CategoryActivity.class);
        if (view.getId() == R.id.button_all_paintings) {
            intent.putExtra("category", "All Paintings");
        } else if (view.getId() == R.id.button_blue_period) {
            intent.putExtra("category", "Blue Period");
        } else if (view.getId() == R.id.button_rose_period) {
            intent.putExtra("category", "Rose Period");
        } else if (view.getId() == R.id.button_cubism) {
            intent.putExtra("category", "Cubism");
        } else if (view.getId() == R.id.button_classicism_surrealism) {
            intent.putExtra("category", "Classicism & Surrealism");
        } else if (view.getId() == R.id.button_later_works) {
            intent.putExtra("category", "Later Works");
        }
        startActivity(intent);
    }
}