package pl.eatwell.converters;

import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import pl.eatwell.commands.DirectionsCommand;
import pl.eatwell.model.Directions;

@Component
public class DirectionsCommandToDirections implements Converter<DirectionsCommand, Directions> {

    @Synchronized
    @Nullable
    @Override
    public Directions convert(DirectionsCommand source) {

        if(source == null){
            return null;
        }

        final Directions directions = new Directions();
        directions.setId(source.getId());
        directions.setNotes(source.getNotes());
        return directions;
    }
}
