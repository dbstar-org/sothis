package org.sothis.mvc;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public abstract class AbstractRequest implements Request {

	private Attributes attributes;
	private Charset charset;
	private UriParser uriParser;
	private Parameters parameters;

	protected UriParser getUriParser() {
		if (null == uriParser) {
			uriParser = new UriParser(getUri(), getCharset());
		}
		return uriParser;
	}

	@Override
	public Attributes attributes() {
		if (null == attributes) {
			attributes = new HashMapAttributes();
		}
		return attributes;
	}

	@Override
	public Charset getCharset() {
		if (null == charset) {
			charset = DEFAULT_CHARSET;
		}
		return charset;
	}

	@Override
	public void setCharset(Charset charset) throws UnsupportedEncodingException {
		this.charset = charset;
	}

	@Override
	public Parameters parameters() {
		if (null == parameters) {
			parameters = new HashMapParameters(getUriParser().parameters());
		}
		return parameters;
	}

	@Override
	public String getQueryString() {
		return getUriParser().queryString();
	}

	@Override
	public String getUriPath() {
		return getUriParser().path();
	}

}
