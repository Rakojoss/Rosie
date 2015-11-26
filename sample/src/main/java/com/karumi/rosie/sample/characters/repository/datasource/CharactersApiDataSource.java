/*
 * Copyright (C) 2015 Karumi.
 */

package com.karumi.rosie.sample.characters.repository.datasource;

import android.support.annotation.NonNull;
import com.karumi.rosie.repository.PaginatedCollection;
import com.karumi.rosie.repository.datasource.paginated.PaginatedReadableDataSource;
import com.karumi.rosie.sample.characters.domain.model.Character;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Random;
import javax.inject.Inject;

public class CharactersApiDataSource implements PaginatedReadableDataSource<Character> {

  private static final int NUMBER_OF_CHARACTERS = 15;
  private static final Random random = new Random(System.nanoTime());

  @Inject public CharactersApiDataSource() {
  }

  @Override public PaginatedCollection<Character> getPage(int offset, int limit) {
    Collection<Character> characters = new LinkedList<>();

    // Wait for 0.5ms
    try {
      Thread.sleep(500);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    for (int i = offset; i - offset < limit && i < NUMBER_OF_CHARACTERS; i++) {
      characters.add(getCharacter(i));
    }

    PaginatedCollection<Character> charactersPage = new PaginatedCollection<>(characters);
    charactersPage.setOffset(offset);
    charactersPage.setLimit(limit);
    charactersPage.setHasMore(offset < NUMBER_OF_CHARACTERS);
    return charactersPage;
  }

  private Character getCharacter(int i) {
    Character[] characters =
        {getSpiderman(), getCaptainMarvel(), getHulk(), getThor(), getIronMan()};

    Character character = characters[random.nextInt(characters.length)];
    character.setName(character.getName() + " " + i);
    return character;
  }

  @NonNull private Character getSpiderman() {
    Character spiderman = new Character();
    spiderman.setId("54");
    spiderman.setName("Spiderman");
    spiderman.setThumbnailUrl("http://x.annihil.us/u/prod/marvel/i/mg/6/60/538cd3628a05e.jpg");
    spiderman.setDescription(
        "Bitten by a radioactive spider, high school student Peter Parker gained the speed, "
            + "strength and powers of a spider. Adopting the name Spider-Man, Peter hoped to start"
            + " a career using his new abilities. Taught that with great power comes great"
            + " responsibility, Spidey has vowed to use his powers to help people.");
    return spiderman;
  }

  @NonNull private Character getCaptainMarvel() {
    Character captainMarvel = new Character();
    captainMarvel.setId("9");
    captainMarvel.setName("Captain Marvel");
    captainMarvel.setThumbnailUrl("http://x.annihil.us/u/prod/marvel/i/mg/6/30/537ba61b764b4.jpg");
    captainMarvel.setDescription(
        "Carol Danvers entered the Air Force upon graduating from high school to pursue her love"
            + " of aircrafts and her dreams of flying.");
    return captainMarvel;
  }

  @NonNull private Character getHulk() {
    Character hulk = new Character();
    hulk.setId("25");
    hulk.setName("Hulk");
    hulk.setThumbnailUrl("http://x.annihil.us/u/prod/marvel/i/mg/e/e0/537bafa34baa9.jpg");
    hulk.setDescription(
        "Caught in a gamma bomb explosion while trying to save the life of a teenager, Dr. Bruce"
            + " Banner was transformed into the incredibly powerful creature called the Hulk. An"
            + " all too often misunderstood hero, the angrier the Hulk gets, the stronger the Hulk"
            + " gets.");
    return hulk;
  }

  @NonNull private Character getThor() {
    Character hulk = new Character();
    hulk.setId("60");
    hulk.setName("Thor");
    hulk.setThumbnailUrl("http://x.annihil.us/u/prod/marvel/i/mg/7/10/537bc71e9286f.jpg");
    hulk.setDescription(
        "As the Norse God of thunder and lightning, Thor wields one of the greatest weapons ever"
            + " made, the enchanted hammer Mjolnir. While others have described Thor as an"
            + " over-muscled, oafish imbecile, he's quite smart and compassionate."
            + " He's self-assured, and he would never, ever stop fighting for a worthwhile cause.");
    return hulk;
  }

  @NonNull private Character getIronMan() {
    Character hulk = new Character();
    hulk.setId("29");
    hulk.setName("Iron Man");
    hulk.setThumbnailUrl("http://i.annihil.us/u/prod/marvel/i/mg/c/60/55b6a28ef24fa.jpg");
    hulk.setDescription(
        "Wounded, captured and forced to build a weapon by his enemies, billionaire industrialist"
            + " Tony Stark instead created an advanced suit of armor to save his life and escape"
            + " captivity. Now with a new outlook on life, Tony uses his money and intelligence"
            + " to make the world a safer, better place as Iron Man.");
    return hulk;
  }
}
