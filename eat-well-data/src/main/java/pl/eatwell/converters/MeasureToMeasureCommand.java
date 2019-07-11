package pl.eatwell.converters;

import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import pl.eatwell.commands.MeasureCommand;
import pl.eatwell.model.Measure;

public class MeasureToMeasureCommand implements Converter<Measure, MeasureCommand> {

    @Synchronized
    @Nullable
    @Override
    public MeasureCommand convert(Measure source) {
        if(source == null){
            return null;
        }
        final MeasureCommand measureCommand = new MeasureCommand();
        measureCommand.setId(source.getId());
        measureCommand.setDescription(source.getDescription());
        measureCommand.setAmount(source.getAmount());
        measureCommand.setWeightInGrams(source.getWeighInGrams());
        return measureCommand;
    }
}
