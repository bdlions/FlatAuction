"use strict";
var PacketHeader_1 = require("./PacketHeader");
var ACTION_1 = require("./ACTION");
var REQUEST_TYPE_1 = require("./REQUEST_TYPE");
var index_js_1 = require("./../../node_modules/angular2-uuid/index.js");
var PacketHeaderFactory = (function () {
    function PacketHeaderFactory() {
    }
    PacketHeaderFactory.getHeader = function (action) {
        var packetHeader = new PacketHeader_1.PacketHeader();
        packetHeader.sessionId = "sessionId";
        packetHeader.action = action;
        packetHeader.packetId = index_js_1.UUID.UUID();
        switch (action) {
            case ACTION_1.ACTION.SIGN_UP:
                packetHeader.requestType = REQUEST_TYPE_1.REQUEST_TYPE.AUTH;
                break;
            case ACTION_1.ACTION.SIGN_IN:
                packetHeader.requestType = REQUEST_TYPE_1.REQUEST_TYPE.AUTH;
                break;
            case ACTION_1.ACTION.FETCH_PRODUCT_LIST:
                packetHeader.requestType = REQUEST_TYPE_1.REQUEST_TYPE.REQUEST;
                break;
            case ACTION_1.ACTION.FETCH_LOCATION_LIST:
                packetHeader.requestType = REQUEST_TYPE_1.REQUEST_TYPE.REQUEST;
                break;
            case ACTION_1.ACTION.FETCH_RADIUS_LIST:
                packetHeader.requestType = REQUEST_TYPE_1.REQUEST_TYPE.REQUEST;
                break;
            case ACTION_1.ACTION.FETCH_PRODUCT_TYPE_LIST:
                packetHeader.requestType = REQUEST_TYPE_1.REQUEST_TYPE.REQUEST;
                break;
            case ACTION_1.ACTION.FETCH_OCCUPATION_LIST:
                packetHeader.requestType = REQUEST_TYPE_1.REQUEST_TYPE.REQUEST;
                break;
            case ACTION_1.ACTION.FETCH_GENDER_LIST:
                packetHeader.requestType = REQUEST_TYPE_1.REQUEST_TYPE.REQUEST;
                break;
            case ACTION_1.ACTION.FETCH_ROOM_SIZE_LIST:
                packetHeader.requestType = REQUEST_TYPE_1.REQUEST_TYPE.REQUEST;
                break;
            case ACTION_1.ACTION.FETCH_DURATION_LIST:
                packetHeader.requestType = REQUEST_TYPE_1.REQUEST_TYPE.REQUEST;
                break;
            case ACTION_1.ACTION.FETCH_MIN_PRICE_LIST:
                packetHeader.requestType = REQUEST_TYPE_1.REQUEST_TYPE.REQUEST;
                break;
            case ACTION_1.ACTION.FETCH_MAX_PRICE_LIST:
                packetHeader.requestType = REQUEST_TYPE_1.REQUEST_TYPE.REQUEST;
                break;
            default:
                packetHeader.requestType = REQUEST_TYPE_1.REQUEST_TYPE.NONE;
        }
        return packetHeader;
    };
    return PacketHeaderFactory;
}());
exports.PacketHeaderFactory = PacketHeaderFactory;
//# sourceMappingURL=PacketHeaderFactory.js.map