// This file can be replaced during build by using the `fileReplacements` array.
// `ng build --prod` replaces `environment.ts` with `environment.prod.ts`.
// The list of file replacements can be found in `angular.json`.

export const environment = {
  loginUser: "http://localhost:4000/Wanderlust_Server/UserAPI/userLogin",
  registerUser: "http://localhost:4000/Wanderlust_Server/UserAPI/userRegister",
  getContinents:
    "http://localhost:4000/Wanderlust_Server/PackageAPI/getContinents",
  getPackages: "http://localhost:4000/Wanderlust_Server/PackageAPI/getPackages",
  getPackageDeals:
    "http://localhost:4000/Wanderlust_Server/PackageAPI/getPackageDeals",
  getBookings:
    "http://localhost:4000/Wanderlust_Server/BookingAPI/getBookings/",
  makeBooking: "http://localhost:4000/Wanderlust_Server/BookingAPI/makeBooking",
  cancelBooking:
    "http://localhost:4000/Wanderlust_Server/BookingAPI/cancelBooking/",
  getBookingbyId:
    "http://localhost:4000/Wanderlust_Server/PackageAPI/getPackageById/",
  production: false,
};

//added a comment

//my comment

//added a comment
/*
 * For easier debugging in development mode, you can import the following file
 * to ignore zone related error stack frames such as `zone.run`, `zoneDelegate.invokeTask`.
 *
 * This import should be commented out in production mode because it will have a negative impact
 * on performance if an error is thrown.
 */
// import 'zone.js/dist/zone-error';  // Included with Angular CLI.
