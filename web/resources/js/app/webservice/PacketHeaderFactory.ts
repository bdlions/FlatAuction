import {PacketHeader} from './PacketHeader';
import {ACTION} from './ACTION';
import {REQUEST_TYPE} from './REQUEST_TYPE';
import {UUID} from './../../node_modules/angular2-uuid/index.js';

export class PacketHeaderFactory {
    public static getHeader(action: ACTION):PacketHeader{
        let packetHeader = new PacketHeader();
        packetHeader.sessionId = "sessionId";
        packetHeader.action = action;
        packetHeader.packetId = UUID.UUID();
        switch(action){
            case ACTION.SIGN_UP:
                packetHeader.requestType = REQUEST_TYPE.AUTH
                break;
            case ACTION.SIGN_IN:
                packetHeader.requestType = REQUEST_TYPE.AUTH
                break;
            case ACTION.FETCH_PRODUCT_LIST:
                packetHeader.requestType = REQUEST_TYPE.REQUEST
                break;
            case ACTION.FETCH_LOCATION_LIST:
                packetHeader.requestType = REQUEST_TYPE.REQUEST
                break;
            case ACTION.FETCH_RADIUS_LIST:
                packetHeader.requestType = REQUEST_TYPE.REQUEST
                break;
            case ACTION.FETCH_PRODUCT_TYPE_LIST:
                packetHeader.requestType = REQUEST_TYPE.REQUEST
                break;
            case ACTION.FETCH_OCCUPATION_LIST:
                packetHeader.requestType = REQUEST_TYPE.REQUEST
                break;
            case ACTION.FETCH_GENDER_LIST:
                packetHeader.requestType = REQUEST_TYPE.REQUEST
                break;
            case ACTION.FETCH_ROOM_SIZE_LIST:
                packetHeader.requestType = REQUEST_TYPE.REQUEST
                break;
            case ACTION.FETCH_DURATION_LIST:
                packetHeader.requestType = REQUEST_TYPE.REQUEST
                break;
            case ACTION.FETCH_MIN_PRICE_LIST:
                packetHeader.requestType = REQUEST_TYPE.REQUEST
                break;
            case ACTION.FETCH_MAX_PRICE_LIST:
                packetHeader.requestType = REQUEST_TYPE.REQUEST
                break;
            case ACTION.FETCH_BID_LIST:
                packetHeader.requestType = REQUEST_TYPE.REQUEST
                break;
            case ACTION.FETCH_PRODUCT_INFO:
                packetHeader.requestType = REQUEST_TYPE.REQUEST
                break;
            case ACTION.FETCH_USER_INFO:
                packetHeader.requestType = REQUEST_TYPE.REQUEST
                break;
            case ACTION.FETCH_ACCOUNT_SETTING_FA:
                packetHeader.requestType = REQUEST_TYPE.REQUEST
                break;
            default:
                packetHeader.requestType = REQUEST_TYPE.NONE
        }
        return packetHeader;
    }
}
