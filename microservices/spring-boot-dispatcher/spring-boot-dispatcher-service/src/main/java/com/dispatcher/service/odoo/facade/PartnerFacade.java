package com.dispatcher.service.odoo.facade;

import com.dispatcher.service.model.Partner;
import com.dispatcher.service.exception.DataNotFoundException;
import com.dispatcher.service.exception.DispatcherRuntimeException;
import com.dispatcher.service.odoo.api.*;
import org.apache.xmlrpc.XmlRpcException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PartnerFacade implements OdooPartnerInterface<Partner> {

    private static final Logger logger = LoggerFactory.getLogger(PartnerFacade.class);

    private final String _MODEL = "res.partner";
    private final Session session;

    public PartnerFacade(Session session) {
        this.session = session;
    }

    @Override
    public Partner findByPKey(Integer id) {
        Partner result = null;
        try {
            FilterCollection filters = new FilterCollection();
            filters.add("id", "=", id);
            List<Partner> list = find(filters);
            if (list != null && !list.isEmpty()) {
                result = list.get(0);
            } else {
                throw new DataNotFoundException("No Partner with primary key " + id + " found");
            }
        } catch (Exception e) {
            throw DispatcherRuntimeException.newBuilder()
                    .withMessage(e.getMessage())
                    .withCause(e)
                    .build();
        }
        return result;
    }

    @Override
    public List<Partner> find(Optional<String> name, Optional<String> phone, Optional<String> mobile) {
        List<Partner> result = new ArrayList<>();
        try {
            FilterCollection filters = new FilterCollection();
            if (name.isPresent()) {
                filters.add("name", "=", name.get());
            } else if (phone.isPresent()) {
                filters.add("phone_sanitized", "=", phone.get());
            } else if (mobile.isPresent()) {
                filters.add("mobile", "=", mobile.get());
            }
            result = find(filters);
        } catch (Exception e) {
            throw DispatcherRuntimeException.newBuilder()
                    .withMessage(e.getMessage())
                    .withCause(e)
                    .build();
        }
        return result;
    }

    @Override
    public Partner create(Partner param) {
        Partner result = null;
        try {
            ObjectAdapter adapter = getObjectAdapter();
            Row partner = getObjectAdapter().getNewRow(new String[]{"phone",
                    "email",
                    "mobile",
                    "website",
                    "name",
                    "vat",
                    "company_name",
                    "is_company",
                    "street",
                    "street2",
                    "city",
                    "zip",
                    "state_id",
                    "country_id",
                    "lang",
                    "currency_id"});
            partner.put("phone", param.getPhone());
            partner.put("email", param.getEmail());
            partner.put("mobile", param.getMobile());
            partner.put("website", param.getWebsite());
            partner.put("name", param.getName());
            partner.put("vat", param.getVat());
            partner.put("company_name", param.getCompanyName());
            partner.put("is_company", param.getIsCompany());
            partner.put("street", param.getStreet());
            partner.put("street2", param.getStreet2());
            partner.put("city", param.getCity());
            partner.put("zip", param.getZip());
            partner.put("state_id", param.getStateId());
            partner.put("country_id", param.getCountryId());
            partner.put("lang", param.getLang());
            partner.put("currency_id", param.getCurrencyId());
            adapter.createObject(partner);
        } catch (Exception e) {
            throw DispatcherRuntimeException.newBuilder()
                    .withMessage(e.getMessage())
                    .withCause(e)
                    .build();
        }
        return result;
    }

    @Override
    public Partner update(Integer id, Partner param) {
        Partner result = null;
        try {
            ObjectAdapter adapter = getObjectAdapter();
            Row partner = adapter.getNewRow(new String[]{
                    "id",
                    "phone",
                    "email",
                    "mobile",
                    "website",
                    "name",
                    "vat",
                    "company_name",
                    "is_company",
                    "street",
                    "street2",
                    "city",
                    "zip",
                    "state_id",
                    "country_id",
                    "lang",
                    "currency_id"});
            partner.put("id", param.getId());
            partner.put("phone", param.getPhone());
            partner.put("email", param.getEmail());
            partner.put("mobile", param.getMobile());
            partner.put("website", param.getWebsite());
            partner.put("name", param.getName());
            partner.put("vat", param.getVat());
            partner.put("company_name", param.getCompanyName());
            partner.put("is_company", param.getIsCompany());
            partner.put("street", param.getStreet());
            partner.put("street2", param.getStreet2());
            partner.put("city", param.getCity());
            partner.put("zip", param.getZip());
            partner.put("state_id", param.getStateId());
            partner.put("country_id", param.getCountryId());
            partner.put("lang", param.getLang());
            partner.put("currency_id", param.getCurrencyId());
            adapter.writeObject(partner, true);
        } catch (Exception e) {
            throw DispatcherRuntimeException.newBuilder()
                    .withMessage(e.getMessage())
                    .withCause(e)
                    .build();
        }
        return result;
    }

    @Override
    public void delete(Integer id) {
        try {
            ObjectAdapter adapter = session.getObjectAdapter(_MODEL);
            FilterCollection filters = new FilterCollection();
            filters.add("id", "=", id);
            RowCollection list = adapter.searchAndReadObject(filters, new String[]{});
            adapter.unlinkObject(list);
        } catch (Exception e) {
            throw DispatcherRuntimeException.newBuilder()
                    .withMessage(e.getMessage())
                    .withCause(e)
                    .build();
        }
    }

    private List<Partner> find(FilterCollection filters) {
        List<Partner> result = new ArrayList<>();
        try {
            RowCollection list = getObjectAdapter().searchAndReadObject(filters, new String[]{});
            for (Row row : list) {
                result.add(parse(row));
            }
        } catch (Exception e) {
            throw DispatcherRuntimeException.newBuilder()
                    .withMessage(e.getMessage())
                    .withCause(e)
                    .build();
        }
        return result;
    }

    private Partner parse(Row row) {
        logger.debug(row.toJson());
        Partner partner = Partner.valueOf(row);
        return partner;
    }

    private ObjectAdapter getObjectAdapter() {
        try {
            return session.getObjectAdapter(_MODEL);
        } catch (XmlRpcException e) {
            throw DispatcherRuntimeException.newBuilder()
                    .withMessage(e.getMessage())
                    .withCause(e)
                    .build();
        } catch (OdooApiException e) {
            throw DispatcherRuntimeException.newBuilder()
                    .withMessage(e.getMessage())
                    .withCause(e)
                    .build();
        }
    }
}
