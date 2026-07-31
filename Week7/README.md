# Week 7 — Angular (v20) Mandatory Hands-On

## 🎯 Objective
A single Angular app (`angular-handson`) demonstrating the core module objectives in one place:
components, data binding, directives/pipes, services + dependency injection, routing,
HttpClient + Observables, and reactive forms.

## 🧩 What's inside
```
angular-handson/
├── package.json
├── angular.json
├── tsconfig.json
├── src/
│   ├── index.html, main.ts, styles.css
│   └── app/
│       ├── app.component.ts/html/css      -> root shell + nav (routing outlet)
│       ├── app.routes.ts                  -> route config
│       ├── models/country.model.ts        -> Country interface
│       ├── services/country.service.ts    -> @Injectable, HttpClient GET/POST, Observables
│       └── components/
│           ├── country-list/              -> *ngFor, pipes (uppercase), event binding
│           └── country-form/               -> Reactive Form (FormBuilder, Validators)
```

## ✅ Learning objectives covered
| Objective | Where |
|---|---|
| Components, data binding, lifecycle | `country-list.component.ts` (`ngOnInit`), property/event binding in its template |
| Directives & pipes | `*ngFor`, `*ngIf`, `uppercase` pipe in `country-list.component.html` |
| Reactive forms + validation | `country-form.component.ts` using `FormBuilder`, `Validators.required` |
| Dependency Injection & services | `CountryService` injected into both components via constructor DI |
| Routing | `app.routes.ts` — `/countries` and `/countries/add` |
| HttpClient + Observables | `CountryService.getCountries()` / `addCountry()` return `Observable<Country[]>` |

## ▶️ How to run
```bash
cd angular-handson
npm install
ng serve -o        # or: npm start
```
App runs at `http://localhost:4200`.

> Note: this hands-on points at a placeholder API (`/api/countries`). Swap the `apiUrl` in
> `country.service.ts` for your own backend (e.g., the `spring-learn` REST service from Week 5)
> to see live data end-to-end.
