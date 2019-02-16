
package com.wiley.alm.responsesubscriber.converters;

import java.util.List;

import javax.jms.Message;

import com.wiley.alm.responsesubscriber.model.TargetResponseEvent;


public interface Converter {

	public List<TargetResponseEvent> convert(Message responseEvent) throws Exception;
}
