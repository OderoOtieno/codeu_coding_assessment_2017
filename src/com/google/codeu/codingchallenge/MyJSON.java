// Copyright 2017 Google Inc.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//    http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.codeu.codingchallenge;

import java.util.Collection;
import java.util.*;

final class MyJSON implements JSON {

	private HashMap<String,Object> maps = new HashMap<String,Object>();
	
	
  @Override
  public JSON getObject(String name) {
    if(maps.cointainsKey(name)){
    	return (JSON)maps.get(name);
    }
    return null;
  }

  @Override
  public JSON setObject(String name, JSON value) {
	  if (maps.containsKey(name) && maps.get(name) instanceof JSON) {
			  maps.remove(name);
			  maps.put(name, value);
	  }
	  else {
		  maps.put(name, value);
	  }
    return this;
  }

  @Override
  public String getString(String name) {
	  if(maps.cointainsKey(name)){
	    	return (String)maps.get(name);
	    }
	    return null;
  }

  @Override
  public JSON setString(String name, String value) {
    maps.put(name,value);
    return this;
  }

  @Override
  public void getObjects(Collection<String> names) {
	  for(String key: maps.keySet())
	      if(maps.get(key) instanceof Object)
	        names.add(key);
  }

  @Override
  public void getStrings(Collection<String> names) {
	  for(String key: maps.keySet())
	      if(maps.get(key) instanceof String)
	        names.add(key);
  }
	return 0;
}

