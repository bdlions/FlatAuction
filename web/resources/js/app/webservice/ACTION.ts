export enum ACTION{
    SIGN_IN = 1001,
    SIGN_OUT = 1002,
    FETCH_PRODUCT_LIST = 1003,
    SIGN_UP = 1004,
    
    FETCH_USER_LIST = 2023,
    FETCH_MEMBER_ROLES = 2025,
    FETCH_LOCATION_LIST = 2001,
    FETCH_RADIUS_LIST = 2003,
    FETCH_PRODUCT_TYPE_LIST = 2004,
    FETCH_OCCUPATION_LIST = 2005,
    FETCH_GENDER_LIST = 2006,
    FETCH_ROOM_SIZE_LIST = 2007,
    FETCH_DURATION_LIST = 2008,
    FETCH_MIN_PRICE_LIST = 2009,
    FETCH_MAX_PRICE_LIST = 2010,
    FETCH_BID_LIST = 2011,
    FETCH_PRODUCT_SIZE_LIST = 2012,
    FETCH_PRODUCT_CATEGORY_LIST = 2013,
    FETCH_PRODUCT_AMENITY_LIST = 2024,
    FETCH_AVAILABILITY_LIST = 2027,
    FETCH_STAY_LIST = 2014,
    FETCH_SMOKING_LIST = 2015,
    FETCH_PET_LIST = 2016,
    FETCH_MY_PRODUCT_LIST = 2017,
    FETCH_MESSAGE_INBOX_LIST = 2018,
    FETCH_MESSAGE_INFO = 2019,
    FETCH_MESSAGE_SENT_LIST = 2020,
    FETCH_SAVED_PRODUCT_LIST = 2021,
    FETCH_CLOSING_PRODUCT_LIST = 2022,
    FETCH_STAT_LIST = 2026,
    
    FETCH_PRODUCT_INFO = 3001,
    FETCH_USER_INFO = 3002,
    FETCH_ACCOUNT_SETTING_FA = 3003,
    UPDATE_USER_INFO = 4001,
    UPDATE_USER_PROFILE_PICTURE = 4002,
    UPDATE_USER_DOCUMENT = 4003,
    UPDATE_PRODUCT_INFO = 4004,
    SAVE_ACCOUNT_SETTING_FA = 4005,
    
    ADD_PRODUCT = 5001,
    ADD_PRODUCT_BID = 5002,
    ADD_MESSAGE_TEXT = 5003,
    ADD_MESSAGE_INFO = 5004,
    ADD_SAVED_PRODUCT = 5005,
}