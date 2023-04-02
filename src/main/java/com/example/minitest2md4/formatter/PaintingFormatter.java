package com.example.minitest2md4.formatter;

import com.example.minitest2md4.model.Painting;
import com.example.minitest2md4.service.Painting.IPaintingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;
import java.util.Optional;

@Component
public class PaintingFormatter implements Formatter<Painting> {
@Autowired
    private IPaintingService paintingService;

    @Autowired
    public PaintingFormatter(IPaintingService paintingService) {
        this.paintingService=paintingService;
    }

    @Override
    public Painting parse(String text, Locale locale) throws ParseException {
        Optional<Painting> paintingOptional = paintingService.findById(Long.parseLong(text));
        return paintingOptional.orElse(null);
    }

    @Override
    public String print(Painting object, Locale locale) {
        return "[" + object.getId() + ", " +object.getDescription() + "]";
    }
}
