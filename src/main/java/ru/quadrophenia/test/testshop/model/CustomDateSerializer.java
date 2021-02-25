package ru.quadrophenia.test.testshop.model;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomDateSerializer extends StdSerializer<Date> {

	private static SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");

	public CustomDateSerializer() {
		this(null);
	}

	protected CustomDateSerializer(Class<Date> t) {
		super(t);
	}

	@Override
	public void serialize(Date value, JsonGenerator gen, SerializerProvider provider) throws IOException {
		gen.writeString(formatter.format(value));
	}
}
