package pl.eatwell.converters;

import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import pl.eatwell.commands.MeasureCommand;
import pl.eatwell.model.Measure;

@Component
public class MeasureCommandToMeasure implements Converter<MeasureCommand, Measure> {

    @Synchronized
    @Nullable
    @Override
    public Measure convert(MeasureCommand source) {
        if(source == null){
            return null;
        }
        final Measure measure = new Measure();
        measure.setId(source.getId());
        measure.setDescription(source.getDescription());
        measure.setAmount(source.getAmount());
        measure.setWeighInGrams(source.getWeightInGrams());
        return measure;
    }
}
