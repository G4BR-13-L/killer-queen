import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { HttpClient } from '@angular/common/http'
import { environment } from "src/environments/environment";
import { Colaborador } from "./colaborador";

@Injectable({
    providedIn: 'root'
})
export class ColaboradorService {
    private apiServerUrl = environment.apiBaseUrl;


    constructor(private http: HttpClient) {}

    public getColaboradores(): Observable<Colaborador[]> {
        return this.http.get<Colaborador[]>(`${this.apiServerUrl}/colaborador/all`)
    }

    public addColaborador(colaborador: Colaborador): Observable<Colaborador> {
        return this.http.post<Colaborador>(`${this.apiServerUrl}/colaborador/add`, colaborador);
    }

    public updateColaborador(colaborador: Colaborador): Observable<Colaborador> {
        return this.http.put<Colaborador>(`${this.apiServerUrl}/colaborador/update`, colaborador);
    }

    public deleteColaborador(colaboradorId: number): Observable<void> {
        return this.http.delete<void>(`${this.apiServerUrl}/colaborador/delete/${colaboradorId}`);
    }
}
