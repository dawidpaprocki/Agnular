package application.controllers;

import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class DateConverter {

 public Date convertDate(String stringDate) throws ParseException {
   return new SimpleDateFormat("dd/MM/yyyy").parse(stringDate);
 }
}
