package pl.eatwell.converters;

import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import pl.eatwell.commands.DirectionsCommand;
import pl.eatwell.model.Directions;

@Component
public class DirectionsToDirectionsCommand implements Converter<Directions, DirectionsCommand> {

    @Synchronized
    @Nullable
    @Override
    public DirectionsCommand convert(Directions source) {
        if (source == null) {
            return null;
        }

        final DirectionsCommand directionsCommand = new DirectionsCommand();
        directionsCommand.setId(source.getId());
        directionsCommand.setNotes(source.getNotes());
        return directionsCommand;
    }
}
