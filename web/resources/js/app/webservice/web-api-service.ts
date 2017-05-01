import {Injectable} from "@angular/core";
import {Http, Response, Headers, RequestOptions} from '@angular/http';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/toPromise';
import {Packet} from './Packet'
import {PacketHeader} from './PacketHeader'


@Injectable()
export class WebAPIService {
    private actionUrl = window.SUB_DIRECTORY + '/RequestServlet';
    constructor(private http: Http) {}

    getResponse(packetHeader:PacketHeader, packetBody:string = null) {
        var packet = new Packet();
        
        packet.packetHeader = packetHeader;
        if (packetBody != null && packetBody != "" ){
//            packet.packetBody = JSON.parse(packetBody);
            packet.packetBody = packetBody;
        }
        var headers = new Headers();
        headers.append('Content-Type', 'application/x-www-form-urlencoded');
//        headers.append('Content-Type', 'application/json');
        let options = new RequestOptions({ headers: headers });
        return this.http.post(this.actionUrl, packet, options).
            map((res: Response) => res.json()).
            toPromise().
            then(function (response) {
                return response;
            });
    };

}


