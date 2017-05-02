/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.auction.util;

/**
 *
 * @author alamgir
 */


import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class UrlEncodedQueryString {

    
    public static enum Separator {
       
        AMPERSAND {

          
            @Override
            public String toString() {

                return "&";
            }
        },
       
        SEMICOLON {

           
            @Override
            public String toString() {

                return ";";
            }
        };
    }

   
    public static UrlEncodedQueryString create() {

        return new UrlEncodedQueryString();
    }

    
    public static UrlEncodedQueryString create(Map<String, List<String>> parameterMap) {

        UrlEncodedQueryString queryString = new UrlEncodedQueryString();

        // Defensively copy the List<String>'s
        for (Map.Entry<String, List<String>> entry : parameterMap.entrySet()) {
            queryString.queryMap.put(entry.getKey(), new ArrayList<String>(entry.getValue()));
        }

        return queryString;
    }

    
    public static UrlEncodedQueryString parse(final CharSequence query) {

        UrlEncodedQueryString queryString = new UrlEncodedQueryString();

        // Note: import to call appendOrSet with 'true', in
        // case the given query contains multi-valued parameters
        queryString.appendOrSet(query, true);

        return queryString;
    }

   
    public static UrlEncodedQueryString parse(final URI uri) {

     
        return parse(uri.getRawQuery());
    }

    
    private static final String PARSE_PARAMETER_SEPARATORS = String.valueOf(Separator.AMPERSAND) + Separator.SEMICOLON;

    
    private final Map<String, List<String>> queryMap = new LinkedHashMap<String, List<String>>();

    
    public String get(final String name) {

        List<String> parameters = getValues(name);

        if (parameters == null || parameters.isEmpty()) {
            return null;
        }

        return parameters.get(0);
    }

   
    public boolean contains(final String name) {

        return this.queryMap.containsKey(name);
    }

   
    public Iterator<String> getNames() {

        return this.queryMap.keySet().iterator();
    }

   
    public List<String> getValues(final String name) {

        return this.queryMap.get(name);
    }

    
    public Map<String, List<String>> getMap() {

        LinkedHashMap<String, List<String>> map = new LinkedHashMap<String, List<String>>();

        // Defensively copy the List<String>'s
        for (Map.Entry<String, List<String>> entry : this.queryMap.entrySet()) {
            List<String> listValues = entry.getValue();
            map.put(entry.getKey(), new ArrayList<String>(listValues));
        }

        return map;
    }

    
    public UrlEncodedQueryString set(final String name, final String value) {

        appendOrSet(name, value, false);
        return this;
    }

   
    public UrlEncodedQueryString set(final String name, final Number value) {

        if (value == null) {
            remove(name);
            return this;
        }

        appendOrSet(name, value.toString(), false);
        return this;
    }

    public UrlEncodedQueryString set(final String query) {

        appendOrSet(query, false);
        return this;
    }

    public UrlEncodedQueryString append(final String name, final String value) {

        appendOrSet(name, value, true);
        return this;
    }

   
    public UrlEncodedQueryString append(final String name, final Number value) {

        appendOrSet(name, value.toString(), true);
        return this;
    }

    
    public UrlEncodedQueryString append(final String query) {

        appendOrSet(query, true);
        return this;
    }

    
    public boolean isEmpty() {

        return queryMap.isEmpty();
    }

    
    public UrlEncodedQueryString remove(final String name) {

        appendOrSet(name, null, false);
        return this;
    }

   
    public URI apply(URI uri) {

        return apply(uri, Separator.AMPERSAND);
    }

    
    public URI apply(URI uri, Separator separator) {

       
        StringBuilder builder = new StringBuilder();
        if (uri.getScheme() != null) {
            builder.append(uri.getScheme());
            builder.append(':');
        }
        if (uri.getHost() != null) {
            builder.append("//");
            if (uri.getUserInfo() != null) {
                builder.append(uri.getUserInfo());
                builder.append('@');
            }
            builder.append(uri.getHost());
            if (uri.getPort() != -1) {
                builder.append(':');
                builder.append(uri.getPort());
            }
        } else if (uri.getAuthority() != null) {
            builder.append("//");
            builder.append(uri.getAuthority());
        }
        if (uri.getPath() != null) {
            builder.append(uri.getPath());
        }

        String query = toString(separator);
        if (query.length() != 0) {
            builder.append('?');
            builder.append(query);
        }
        if (uri.getFragment() != null) {
            builder.append('#');
            builder.append(uri.getFragment());
        }

        try {
            return new URI(builder.toString());
        } catch (URISyntaxException e) {
            // Can never happen, as the given URI will always be valid,
            // and getQuery() will always return a valid query string

            throw new RuntimeException(e);
        }
    }

   
    @Override
    public boolean equals(Object obj) {

        if (obj == this) {
            return true;
        }

        if (!(obj instanceof UrlEncodedQueryString)) {
            return false;
        }

        String query = toString();
        String thatQuery = ((UrlEncodedQueryString) obj).toString();

        return query.equals(thatQuery);
    }

    
    @Override
    public int hashCode() {

        return toString().hashCode();
    }

    @Override
    public String toString() {

        return toString(Separator.AMPERSAND);
    }

   
    public String toString(Separator separator) {

        StringBuilder builder = new StringBuilder();

        for (String name : this.queryMap.keySet()) {
            for (String value : this.queryMap.get(name)) {
                if (builder.length() != 0) {
                    builder.append(separator);
                }

                
                try {
                    builder.append(URLEncoder.encode(name, "UTF-8"));

                    if (value != null) {
                        builder.append('=');
                        builder.append(URLEncoder.encode(value, "UTF-8"));
                    }
                } catch (UnsupportedEncodingException e) {
                   
                    throw new RuntimeException(e);
                }
            }
        }

        return builder.toString();
    }

    
    private UrlEncodedQueryString() {

        // Can never be called
    }

   
    private void appendOrSet(final String name, final String value, final boolean append) {

        if (name == null) {
            throw new NullPointerException("name");
        }

        // If we're appending, and there's an existing parameter...
        if (append) {
            List<String> listValues = this.queryMap.get(name);

            // ...add to it
            if (listValues != null) {
                listValues.add(value);
                return;
            }
        } // ...otherwise, if we're setting and the value is null...
        else if (value == null) {
            // ...remove it

            this.queryMap.remove(name);
            return;
        }

        // ...otherwise, create a new one
        List<String> listValues = new ArrayList<String>();
        listValues.add(value);

        this.queryMap.put(name, listValues);
    }

    
    private void appendOrSet(final CharSequence parameters, final boolean append) {

        // Nothing to do?
        if (parameters == null) {
            return;
        }

        // Note we always parse using PARSE_PARAMETER_SEPARATORS, regardless
        // of what the user later nominates as their output parameter
        // separator using toString()
        StringTokenizer tokenizer = new StringTokenizer(parameters.toString(), PARSE_PARAMETER_SEPARATORS);

        Set<String> setAlreadyParsed = null;

        while (tokenizer.hasMoreTokens()) {
            String parameter = tokenizer.nextToken();

            int indexOf = parameter.indexOf('=');

            String name;
            String value;

            try {
                if (indexOf == -1) {
                    name = parameter;
                    value = null;
                } else {
                    name = parameter.substring(0, indexOf);
                    value = parameter.substring(indexOf + 1);
                }

                // Decode the name if necessary (i.e. %70age=1 becomes page=1)
                name = URLDecoder.decode(name, "UTF-8");

                // When not appending, the first time we see a given
                // name it is important to remove it from the existing
                // parameters
                if (!append) {
                    if (setAlreadyParsed == null) {
                        setAlreadyParsed = new HashSet<String>();
                    }

                    if (!setAlreadyParsed.contains(name)) {
                        remove(name);
                    }

                    setAlreadyParsed.add(name);
                }

                if (value != null) {
                    value = URLDecoder.decode(value, "UTF-8");
                }

                appendOrSet(name, value, true);
            } catch (UnsupportedEncodingException e) {
                // Should never happen. UTF-8 should always be available
                // according to Java spec

                throw new RuntimeException(e);
            }
        }
    }
}
