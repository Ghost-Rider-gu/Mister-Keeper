/*
 * Copyright (c) 2020
 * Ghost Rider aka Golubnichenko Yuriy
 */

package corp.siendev.com.keeper.bookservice.domain;

public enum Genre {

    FANTASY("Fantasy"),
    ADVENTURE("Adventure"),
    ROMANCE("Romance"),
    CONTEMPORARY("Contemporary"),
    DYSTOPIAN("Dystopian"),
    MYSTERY("Mystery"),
    HORROR("Horror"),
    THRILLER("Thriller"),
    PARANORMAL("Paranormal"),
    HISTORICAL_FICTION("Historical fiction"),
    SCIENCE_FICTION("Science fiction"),
    MEMOIR("Memoir"),
    COOKING("Cooking"),
    ART("Art"),
    PERSONAL("Personal"),
    DEVELOPMENT("Development"),
    MOTIVATIONAL("Motivational"),
    HEALTH("Health"),
    HISTORY("History"),
    TRAVEL("Travel"),
    HUMOR("Humor"),
    FOR_CHILDREN("For children"),
    FAMILIES_AND_RELATIONSHIPS("Families and relationships"),
    GUIDE("Guide"),
    HOW_TO("How To");

    private String description;

    Genre(String genre) {
        this.description = genre;
    }

    public String getDescription() {
        return description;
    }
}
