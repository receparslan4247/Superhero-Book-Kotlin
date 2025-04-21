package com.receparslan.superherobook.model

import com.receparslan.superherobook.R

data class Superhero(val name: String, val realName: String, val publisher: String, val image: Int, val bio: String) {
    companion object {
        fun getSuperheroes(): List<Superhero> {
            return listOf(
                Superhero(
                    name = "Batman",
                    realName = "Bruce Wayne",
                    publisher = "DC Comics",
                    image = R.drawable.batman,
                    bio = "Batman is a fictional superhero appearing in American comic books published by DC Comics. The character was created by artist Bob Kane and writer Bill Finger, and first appeared in Detective Comics #27 in 1939."
                ),
                Superhero(
                    name = "Superman",
                    realName = "Clark Kent",
                    publisher = "DC Comics",
                    image = R.drawable.superman,
                    bio = "Superman is a fictional superhero. The character was created by writer Jerry Siegel and artist Joe Shuster, and first appeared in the comic book Action Comics #1 in 1938."
                ),
                Superhero(
                    name = "Wonder Woman",
                    realName = "Diana Prince",
                    publisher = "DC Comics",
                    image = R.drawable.wonder_woman,
                    bio = "Wonder Woman is a fictional superhero appearing in American comic books published by DC Comics. The character is a founding member of the Justice League."
                ),
                Superhero(
                    name = "Aquaman",
                    realName = "Arthur Curry",
                    publisher = "DC Comics",
                    image = R.drawable.aquaman,
                    bio = "Aquaman is a fictional superhero appearing in American comic books published by DC Comics. Created by Paul Norris and Mort Weisinger, the character debuted in More Fun Comics #73 in November 1941."
                ),
                Superhero(
                    name = "Flash",
                    realName = "Barry Allen",
                    publisher = "DC Comics",
                    image = R.drawable.flash,
                    bio = "The Flash is a superhero appearing in American comic books published by DC Comics. The character first appeared in Showcase #4, created by writer Robert Kanigher and penciler Carmine Infantino."
                ),
                Superhero(
                    name = "Green Lantern",
                    realName = "Hal Jordan",
                    publisher = "DC Comics",
                    image = R.drawable.green_lantern,
                    bio = "Green Lantern is the name of several superheroes appearing in American comic books published by DC Comics. They fight evil with the aid of rings that grant them a variety of extraordinary powers."
                ),
                Superhero(
                    name = "Captain America",
                    realName = "Steve Rogers",
                    publisher = "Marvel Comics",
                    image = R.drawable.captain_america,
                    bio = "Captain America is a superhero appearing in American comic books published by Marvel Comics. Created by cartoonists Joe Simon and Jack Kirby, the character first appeared in Captain America Comics #1 in 1941."
                ),
                Superhero(
                    name = "Doctor Strange",
                    realName = "Stephen Strange",
                    publisher = "Marvel Comics",
                    image = R.drawable.doctor_strange,
                    bio = "Doctor Strange is a fictional superhero appearing in American comic books published by Marvel Comics. Created by artist Steve Ditko and writer Stan Lee, the character first appeared in Strange Tales #110 in 1963."
                ),
                Superhero(
                    name = "Iron Man",
                    realName = "Tony Stark",
                    publisher = "Marvel Comics",
                    image = R.drawable.iron_man,
                    bio = "Iron Man is a fictional superhero appearing in American comic books published by Marvel Comics. The character was co-created by writer and editor Stan Lee, developed by scripter Larry Lieber, and designed by artists Don Heck and Jack Kirby."
                ),
                Superhero(
                    name = "Thor",
                    realName = "Thor Odinson",
                    publisher = "Marvel Comics",
                    image = R.drawable.thor,
                    bio = "Thor is a fictional superhero appearing in American comic books published by Marvel Comics. The character, which is based on the Norse deity of the same name, is the Asgardian god of thunder who possesses the enchanted hammer, Mjolnir."
                ),
                Superhero(
                    name = "Hulk",
                    realName = "Bruce Banner",
                    publisher = "Marvel Comics",
                    image = R.drawable.hulk,
                    bio = "The Hulk is a fictional superhero appearing in American comic books published by Marvel Comics. Created by writer Stan Lee and artist Jack Kirby, the character first appeared in the debut issue of The Incredible Hulk."
                ),
                Superhero(
                    name = "Black Widow",
                    realName = "Natasha Romanoff",
                    publisher = "Marvel Comics",
                    image = R.drawable.black_widow,
                    bio = "Black Widow is a fictional superhero appearing in American comic books published by Marvel Comics. Created by editor and plotter Stan Lee, scripter Don Rico, and artist Don Heck, the character debuted in Tales of Suspense #52."
                ),
                Superhero(
                    name = "Scarlet Witch",
                    realName = "Wanda Maximoff",
                    publisher = "Marvel Comics",
                    image = R.drawable.scarlet_witch,
                    bio = "Scarlet Witch is a fictional superhero appearing in American comic books published by Marvel Comics. The character was created by writer Stan Lee and artist Jack Kirby, the character first appeared in The X-Men in the Silver Age of Comic Books."
                )
            )
        }

        fun getMarvelSuperheroes(): List<Superhero> {
            return getSuperheroes().filter { it.publisher == "Marvel Comics" }
        }

        fun getDCSuperheroes(): List<Superhero> {
            return getSuperheroes().filter { it.publisher == "DC Comics" }
        }
    }
}