package com.letscode.linx838.java.time;

import java.time.*;
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalAmount;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

  public static void main(String[] args) {
    //Dominios de tempo: data e hora, fuso, segundos, milesimos, centesimos, seculos


    LocalDate localDate = LocalDate.ofEpochDay(31);
    LocalTime localTime = LocalTime.of(12, 30, 15, 12312313);
    LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);

    ZoneId.getAvailableZoneIds().forEach(System.out::println);

    System.out.println("LocalDate.now(): " + localDate); //0: 1/1/1970
    System.out.println("LocalTime.of(): " + localTime);
    System.out.println("LocalDateTime.now(): " + localDateTime);
    System.out.println("ZonedDateTime: " + ZonedDateTime.of(localDateTime, ZoneId.of("Etc/GMT")));
    System.out.println(OffsetTime.of(localTime, ZoneOffset.ofHours(-2)));
    System.out.println("ZonedDateTime: " + ZonedDateTime.now());
    System.out.println("OffsetDateTime: " + OffsetDateTime.now());

    LocalDateTime nowResult = LocalDateTime.now().plus(1l, ChronoUnit.CENTURIES);
    System.out.println("nowPlus10: " + nowResult);

    LocalDate agora = LocalDate.now();
    LocalDate primeiroDiaDoMes = agora.with(TemporalAdjusters.firstDayOfMonth());
    System.out.println(agora);
    System.out.println(primeiroDiaDoMes);
    long diffDays = primeiroDiaDoMes.until(agora, ChronoUnit.DAYS);
    System.out.println("diffDays: " + diffDays);

    System.out.println(agora.isBefore(primeiroDiaDoMes));

    System.out.println(LocalDate.now().atTime(LocalTime.MIN));

    System.out.println(LocalDateTime.now().toLocalDate());
    System.out.println(LocalDateTime.now().atZone(ZoneId.of("Etc/GMT")));
    System.out.println(LocalDateTime.now().atOffset(ZoneOffset.ofHours(0)));

    System.out.println(ZonedDateTime.now().withZoneSameLocal(ZoneId.of("Etc/GMT")));
    System.out.println(ZonedDateTime.now().withZoneSameInstant(ZoneId.of("Etc/GMT")));

    var zonedDateTimeNow = ZonedDateTime.now();
    var zonedDateTimeSameInstant = zonedDateTimeNow.withZoneSameLocal(ZoneId.of("Etc/GMT"));
    System.out.println(zonedDateTimeNow);
    System.out.println(zonedDateTimeSameInstant);
    System.out.println(zonedDateTimeNow.until(zonedDateTimeSameInstant, ChronoUnit.HOURS));
    System.out.println(zonedDateTimeNow.toOffsetDateTime());

    OffsetDateTime offsetDateTimeNow = OffsetDateTime.now(); //-3
    OffsetDateTime offsetDateTimeSameInstant = offsetDateTimeNow.withOffsetSameInstant(ZoneOffset.ofHours(1));
    System.out.println(offsetDateTimeNow);
    System.out.println(offsetDateTimeSameInstant);
    System.out.println(offsetDateTimeNow.until(offsetDateTimeSameInstant, ChronoUnit.HOURS));

    LocalDate proxSeg = LocalDate.now().with(TemporalAdjusters.previousOrSame(DayOfWeek.THURSDAY));
    System.out.println(proxSeg);

//    System.out.println("Instant.now(): " + Instant.now());
//    System.out.println("Instant parsed: " + Instant.parse("2022-03-14T13:43:04.429703743Z"));
//    System.out.println("OffsetDateTime parsed: " + ZonedDateTime.parse("2022-03-13T19:01:45.768149722-03:00"));
//    System.out.println("Clock.systemUTC(): " + Clock.systemUTC());
//    System.out.println("Clock.systemDefaultZone(): " + Clock.systemDefaultZone());
//    System.out.println("Year.now(): " + Year.now());
//    System.out.println("YearMonth.now(): " + YearMonth.now());
//    System.out.println("MonthDay.now(): " + MonthDay.now());
//    System.out.println("ZonedDateTime.now(): " + ZonedDateTime.now());
//    System.out.println("ZonedDateTime.now(UTC): " + ZonedDateTime.now(ZoneOffset.UTC));
//    System.out.println("OffsetDateTime.now(): " + OffsetDateTime.now());
//
//
////    Arrays.stream(TimeZone.getAvailableIDs()).forEach(System.out::println);
//
//    OffsetDateTime now = OffsetDateTime.of(LocalDateTime.now(), ZoneOffset.ofHours(0));
////    OffsetDateTime oneHourLess = now.atZoneSameInstant(ZoneId.ofOffset("GMT", ZoneOffset.ofHours(-1))).toOffsetDateTime();
//    OffsetDateTime oneHourLess = now.atZoneSimilarLocal(ZoneId.ofOffset("GMT", ZoneOffset.ofHours(-1))).toOffsetDateTime();
//    System.out.println("Offset1: " + now);
//    System.out.println("Offset2: " + oneHourLess);
//    long until = now.until(oneHourLess, ChronoUnit.HOURS);
//    System.out.println("offset1 - offset2: " + until);
//
//    ZonedDateTime gmt = now.atZoneSameInstant(ZoneId.ofOffset("", ZoneOffset.ofHours(-3)));
//    System.out.println("(-3): " + gmt);
//
////    System.out.println(OffsetDateTime.parse("2022-04-07T17:56:12-00:00"));
//
//    ZonedDateTime z1 = ZonedDateTime.now();
//    ZonedDateTime z2 = z1.withZoneSameLocal(ZoneId.of("Europe/London"));
//    ZonedDateTime z3 = z1.withZoneSameInstant(ZoneId.of("Japan"));
//    System.out.println("z1: " + z1);
//    System.out.println("z2 (z1 with zone same local): " + z2);
//    System.out.println("z3 (z1 with zone same instant): " + z3);
//    System.out.println("z1 - z2: " + z1.until(z2, ChronoUnit.HOURS));
//    System.out.println("z1 - z3: " + z1.until(z3, ChronoUnit.HOURS));
//
//    System.out.println(LocalDate.now().getDayOfWeek().getValue());
//    System.out.println(LocalDate.now().getDayOfMonth());
//    System.out.println(LocalDate.now().getDayOfYear());
//
//    LocalDate localDate = LocalDate.now().with(TemporalAdjusters.firstDayOfMonth());
//    System.out.println(localDate);
//
//    //    ZoneId.getAvailableZoneIds().forEach(System.out::println);
//
//    System.out.println(ZoneId.systemDefault());
//    System.out.println(ZoneOffset.ofHours(2));
//
    var firstDayOfMonth = ZonedDateTime.now();
    System.out.println("X: " + firstDayOfMonth.format(DateTimeFormatter.ofPattern("Y-MM-dd_HH_mm_ss_xxx")));
    System.out.println(
        firstDayOfMonth.format(
            DateTimeFormatter.ofPattern("EEEE, dd/L/Y - HH:mm:ss VV")));
//    System.out.println(firstDayOfMonth.format(DateTimeFormatter.ofPattern("e, d/L/Y - hh:mm:ss VV")));
    System.out.println("aaa: "+ firstDayOfMonth.format(DateTimeFormatter.ofPattern("cccc, D/M/yyyy - HH:mm:ss xxx")));
    System.out.println("bbb: "+ firstDayOfMonth.format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH_mm_ss_xxx")));
//    System.out.println(firstDayOfMonth.format(DateTimeFormatter.ofPattern("cccc, DD/M/yyyy - HH:mm:ss zz")));
    System.out.println(firstDayOfMonth.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
    System.out.println(firstDayOfMonth.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)));
    System.out.println(firstDayOfMonth.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)));
    System.out.println(firstDayOfMonth.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)));
//
    //TODO verificado
//    "Y-MM-dd_HH_mm_ss_xxx"

//    ZonedDateTime data1 = ZonedDateTime.parse("2022-03-17 10:04:31-03:00", DateTimeFormatter.ofPattern("Y-MM-dd_HH_mm_ss_xxx"));

    System.out.println("Este: " + ZonedDateTime.parse("2022-03-22_19_36_42_-03:00", DateTimeFormatter.ofPattern("yyyy-MM-dd_HH_mm_ss_xxx")));



    OffsetDateTime data2 = OffsetDateTime.parse("2022-03-13T19:01:45.768149722+03:00");
//    System.out.println("Data1: " + data1);
    System.out.println("Data2: " + data2);
    //    long diffHours = data1.until(data2, ChronoUnit.HOURS);
    //    System.out.println("Diff hours: " + diffHours);
    //
    //    System.out.println(ZonedDateTime.parse("2022-03-13T20:17:43.936594508Z[Europe/London]"));
    //    System.out.println(OffsetDateTime.parse("2022-03-13T20:17:43.936594508Z[Europe/London]",
    // DateTimeFormatter.ISO_ZONED_DATE_TIME));

    System.out.println(
        zonedDateTimeNow.format(
            DateTimeFormatter.ofPattern("HH:mm:ss, d 'qualquer coisa mesmo d' MMMM 'de' y (xxx)")));

    System.out.println(LocalDate.of(1969, 12, 31).toEpochDay());
    //    TemporalAdjusters.pre

    // Exercicio 01 - Qual sua idade em segundos até o presente momento?
    LocalDateTime date1 = LocalDateTime.of(2022, 3, 21, 0, 0, 0);
    LocalDateTime date2 = LocalDateTime.of(2022, 3, 22, 0, 0, 0);
    System.out.println(date1.until(date2, ChronoUnit.SECONDS));
    System.out.println(1 * 24 * 60 * 60);

    //Exercicio 02 - Qual a data/hora neste instante no fuso de "Portugal"?
    //Exercicio 03 - Qual a data/hora neste instante no fuso -02:00?
    //Exercicio 04 - Formatar uma data no seguinte padrão: "19:00:00, 17 de março de 2022 (fuso: -03:00)"

  }
}
