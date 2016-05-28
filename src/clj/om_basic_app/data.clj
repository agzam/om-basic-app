(ns om-basic-app.data)

(def ledger-items [{:id                "fbc6678b-4d37-457d-87c5-27ad61b590ee"
                    :name              :funding
                    :account-type      :nominal
                    :balance-type      :any
                    :description       "Funding"
                    :account-item-data [{:id          "e031f369-ed5b-4746-8605-2e0096bc28f1"
                                         :created     "Wednesday, September 23, 2015 9:54 AM"
                                         :credit      92748
                                         :debit       95304
                                         :description "Wiring officia qui mollit aute ipsum"
                                         :customerId  "f44ca3aa-1e41-4493-b512-2d609e9d52d4"}
                                        {:id          "7b7cd7cf-85fe-4c5a-85cc-dd7c1c410546"
                                         :created     "Friday, May 22, 2015 9:52 AM"
                                         :credit      48802
                                         :debit       50737
                                         :description "Wiring adipisicing veniam aute ea tempor"
                                         :customer-id "12092bad-6d9f-4d15-8b91-b83b8e386a5c"}
                                        {:id          "0de3178a-f689-4452-be6a-dd8f158aacad"
                                         :created     "Wednesday, December 3, 2014 7:10 AM"
                                         :credit      5503
                                         :debit       54701
                                         :description "Wiring ea in aliqua occaecat excepteur"
                                         :customer-id "688b04e0-fa86-4c3f-a636-35807ce5246a"}]}
                   {:id                "8c7e8a4b-4628-4c09-91a0-b373397f3891"
                    :name              :unmapped-post-fund
                    :account-type      :nominal
                    :balance-type      :any
                    :description       "Unmapped Investor Funds (Post Fund)"
                    :account-item-data [{:id          "e031f369-ed5b-4746-8605-2e0096bc28f1"
                                         :created     "Wednesday, September 23, 2015 9:54 AM"
                                         :credit      92748
                                         :debit       95304
                                         :description "Wiring officia qui mollit aute ipsum"
                                         :customerId  "f44ca3aa-1e41-4493-b512-2d609e9d52d4"}
                                        {:id          "7b7cd7cf-85fe-4c5a-85cc-dd7c1c410546"
                                         :created     "Friday, May 22, 2015 9:52 AM"
                                         :credit      48802
                                         :debit       50737
                                         :description "Wiring adipisicing veniam aute ea tempor"
                                         :customer-id "12092bad-6d9f-4d15-8b91-b83b8e386a5c"}
                                        {:id          "0de3178a-f689-4452-be6a-dd8f158aacad"
                                         :created     "Wednesday, December 3, 2014 7:10 AM"
                                         :credit      5503
                                         :debit       54701
                                         :description "Wiring ea in aliqua occaecat excepteur"
                                         :customer-id "688b04e0-fa86-4c3f-a636-35807ce5246a"}
                                        {:id          "c4b5c8a9-c7b1-4550-a83a-d4b9f7321244"
                                         :created     "Wednesday, December 3, 2014 7:10 AM"
                                         :credit      5503
                                         :debit       54701
                                         :description "Wiring ea in aliqua occaecat excepteur"
                                         :customer-id "688b04e0-fa86-4c3f-a636-35807ce5246a"}
                                        ]}
                   {:id                "fa1ea566-e523-4919-acb5-81858063fe64"
                    :name              :unmapped-pre-fund
                    :account-type      :nominal
                    :balance-type      :any
                    :description       "Unmapped Investor Funds (Pre Fund)"
                    :account-item-data [{:id          "e031f369-ed5b-4746-8605-2e0096bc28f1"
                                         :created     "Wednesday, September 23, 2015 9:54 AM"
                                         :credit      92748
                                         :debit       95304
                                         :description "Wiring officia qui mollit aute ipsum"
                                         :customerId  "f44ca3aa-1e41-4493-b512-2d609e9d52d4"}
                                        {:id          "7b7cd7cf-85fe-4c5a-85cc-dd7c1c410546"
                                         :created     "Friday, May 22, 2015 9:52 AM"
                                         :credit      48802
                                         :debit       50737
                                         :description "Wiring adipisicing veniam aute ea tempor"
                                         :customer-id "12092bad-6d9f-4d15-8b91-b83b8e386a5c"}
                                        {:id          "0de3178a-f689-4452-be6a-dd8f158aacad"
                                         :created     "Wednesday, December 3, 2014 7:10 AM"
                                         :credit      5503
                                         :debit       54701
                                         :description "Wiring ea in aliqua occaecat excepteur"
                                         :customer-id "688b04e0-fa86-4c3f-a636-35807ce5246a"}
                                        {:id          "c4b5c8a9-c7b1-4550-a83a-d4b9f7321244"
                                         :created     "Wednesday, December 3, 2014 7:10 AM"
                                         :credit      5503
                                         :debit       54701
                                         :description "Wiring ea in aliqua occaecat excepteur"
                                         :customer-id "688b04e0-fa86-4c3f-a636-35807ce5246a"}
                                        ]}
                   {:id                "2807c0f8-3c22-4090-b01c-2107c6fbc9ca"
                    :name              :accounts-receivable
                    :account-type      :nominal
                    :balance-type      :any
                    :description       "Accounts Receivables"
                    :account-item-data [{:id          "e031f369-ed5b-4746-8605-2e0096bc28f1"
                                         :created     "Wednesday, September 23, 2015 9:54 AM"
                                         :credit      92748
                                         :debit       95304
                                         :description "Wiring officia qui mollit aute ipsum"
                                         :customerId  "f44ca3aa-1e41-4493-b512-2d609e9d52d4"}
                                        {:id          "7b7cd7cf-85fe-4c5a-85cc-dd7c1c410546"
                                         :created     "Friday, May 22, 2015 9:52 AM"
                                         :credit      48802
                                         :debit       50737
                                         :description "Wiring adipisicing veniam aute ea tempor"
                                         :customer-id "12092bad-6d9f-4d15-8b91-b83b8e386a5c"}
                                        {:id          "0de3178a-f689-4452-be6a-dd8f158aacad"
                                         :created     "Wednesday, December 3, 2014 7:10 AM"
                                         :credit      5503
                                         :debit       54701
                                         :description "Wiring ea in aliqua occaecat excepteur"
                                         :customer-id "688b04e0-fa86-4c3f-a636-35807ce5246a"}
                                        {:id          "c4b5c8a9-c7b1-4550-a83a-d4b9f7321244"
                                         :created     "Wednesday, December 3, 2014 7:10 AM"
                                         :credit      5503
                                         :debit       54701
                                         :description "Wiring ea in aliqua occaecat excepteur"
                                         :customer-id "688b04e0-fa86-4c3f-a636-35807ce5246a"}
                                        ]}
                   {:id                "cd137a51-6591-449b-9ad9-871d3216b3f7"
                    :name              :pooled
                    :account-type      :real
                    :balance-type      :any
                    :description       "Pooled Investors Account"
                    :account-item-data [{:id          "9017e38b-05f3-474b-9163-57640b7ec803"
                                         :created     "Wednesday, September 23, 2015 9:54 AM"
                                         :credit      5555
                                         :debit       0
                                         :description "Wiring officia qui mollit aute ipsum"
                                         :customerId  "f44ca3aa-1e41-4493-b512-2d609e9d52d4"}
                                        {:id          "baa1ad46-d1de-4428-915f-ae08def79883"
                                         :created     "Friday, May 22, 2015 9:52 AM"
                                         :credit      48802
                                         :debit       50737
                                         :description "Wiring adipisicing veniam aute ea tempor"
                                         :customer-id "12092bad-6d9f-4d15-8b91-b83b8e386a5c"}
                                        {:id          "be31e52d-ba94-44d4-a1c3-3dd3f171c58b"
                                         :created     "Wednesday, December 3, 2014 7:10 AM"
                                         :credit      5503
                                         :debit       54701
                                         :description "Wiring ea in aliqua occaecat excepteur"
                                         :customer-id "688b04e0-fa86-4c3f-a636-35807ce5246a"}
                                        {:id          "243f2723-4405-4c57-92df-52710fe60489"
                                         :created     "Wednesday, September 23, 2015 9:54 AM"
                                         :credit      5555
                                         :debit       0
                                         :description "Wiring officia qui mollit aute ipsum"
                                         :customerId  "f44ca3aa-1e41-4493-b512-2d609e9d52d4"}]}
                   {:id                "4a28a4f0-2dea-456e-8b42-a5a7e12265a2"
                    :name              :other-funding
                    :account-type      :real
                    :balance-type      :any
                    :description       "Trust Funding Account"
                    :account-item-data [{:id          "e031f369-ed5b-4746-8605-2e0096bc28f1"
                                         :created     "Wednesday, September 23, 2015 9:54 AM"
                                         :credit      92748
                                         :debit       95304
                                         :description "Wiring officia qui mollit aute ipsum"
                                         :customerId  "f44ca3aa-1e41-4493-b512-2d609e9d52d4"}
                                        {:id          "7b7cd7cf-85fe-4c5a-85cc-dd7c1c410546"
                                         :created     "Friday, May 22, 2015 9:52 AM"
                                         :credit      48802
                                         :debit       50737
                                         :description "Wiring adipisicing veniam aute ea tempor"
                                         :customer-id "12092bad-6d9f-4d15-8b91-b83b8e386a5c"}
                                        {:id          "0de3178a-f689-4452-be6a-dd8f158aacad"
                                         :created     "Wednesday, December 3, 2014 7:10 AM"
                                         :credit      5503
                                         :debit       54701
                                         :description "Wiring ea in aliqua occaecat excepteur"
                                         :customer-id "688b04e0-fa86-4c3f-a636-35807ce5246a"}
                                        {:id          "c4b5c8a9-c7b1-4550-a83a-d4b9f7321244"
                                         :created     "Wednesday, December 3, 2014 7:10 AM"
                                         :credit      5503
                                         :debit       54701
                                         :description "Wiring ea in aliqua occaecat excepteur"
                                         :customer-id "688b04e0-fa86-4c3f-a636-35807ce5246a"}
                                        ]}
                   {:id                "000a8f8c-17f0-4a4f-8611-36ad7bb2283f"
                    :name              :working-capital
                    :account-type      :real
                    :balance-type      :any
                    :description       "Working Capital Account"
                    :account-item-data [{:id          "e031f369-ed5b-4746-8605-2e0096bc28f1"
                                         :created     "Wednesday, September 23, 2015 9:54 AM"
                                         :credit      92748
                                         :debit       95304
                                         :description "Wiring officia qui mollit aute ipsum"
                                         :customerId  "f44ca3aa-1e41-4493-b512-2d609e9d52d4"}
                                        {:id          "7b7cd7cf-85fe-4c5a-85cc-dd7c1c410546"
                                         :created     "Friday, May 22, 2015 9:52 AM"
                                         :credit      48802
                                         :debit       50737
                                         :description "Wiring adipisicing veniam aute ea tempor"
                                         :customer-id "12092bad-6d9f-4d15-8b91-b83b8e386a5c"}
                                        {:id          "0de3178a-f689-4452-be6a-dd8f158aacad"
                                         :created     "Wednesday, December 3, 2014 7:10 AM"
                                         :credit      5503
                                         :debit       54701
                                         :description "Wiring ea in aliqua occaecat excepteur"
                                         :customer-id "688b04e0-fa86-4c3f-a636-35807ce5246a"}
                                        {:id          "c4b5c8a9-c7b1-4550-a83a-d4b9f7321244"
                                         :created     "Wednesday, December 3, 2014 7:10 AM"
                                         :credit      5503
                                         :debit       54701
                                         :description "Wiring ea in aliqua occaecat excepteur"
                                         :customer-id "688b04e0-fa86-4c3f-a636-35807ce5246a"}
                                        ]}
                   {:id                "a97e0989-0dff-4b1e-b5b1-2c312456f0d6"
                    :name              :working-servicing
                    :account-type      :real
                    :balance-type      :any
                    :description       "Servicing Account"
                    :account-item-data [{:id          "e031f369-ed5b-4746-8605-2e0096bc28f1"
                                         :created     "Wednesday, September 23, 2015 9:54 AM"
                                         :credit      92748
                                         :debit       95304
                                         :description "Wiring officia qui mollit aute ipsum"
                                         :customerId  "f44ca3aa-1e41-4493-b512-2d609e9d52d4"}
                                        {:id          "7b7cd7cf-85fe-4c5a-85cc-dd7c1c410546"
                                         :created     "Friday, May 22, 2015 9:52 AM"
                                         :credit      48802
                                         :debit       50737
                                         :description "Wiring adipisicing veniam aute ea tempor"
                                         :customer-id "12092bad-6d9f-4d15-8b91-b83b8e386a5c"}
                                        {:id          "0de3178a-f689-4452-be6a-dd8f158aacad"
                                         :created     "Wednesday, December 3, 2014 7:10 AM"
                                         :credit      5503
                                         :debit       54701
                                         :description "Wiring ea in aliqua occaecat excepteur"
                                         :customer-id "688b04e0-fa86-4c3f-a636-35807ce5246a"}
                                        {:id          "c4b5c8a9-c7b1-4550-a83a-d4b9f7321244"
                                         :created     "Wednesday, December 3, 2014 7:10 AM"
                                         :credit      5503
                                         :debit       54701
                                         :description "Wiring ea in aliqua occaecat excepteur"
                                         :customer-id "688b04e0-fa86-4c3f-a636-35807ce5246a"}
                                        ]}
                   {:id                "65295814-fd68-4ae9-9ba4-e7a75843979f"
                    :name              :operating
                    :account-type      :real
                    :balance-type      :any
                    :description       "Operating Account"
                    :account-item-data [{:id          "e031f369-ed5b-4746-8605-2e0096bc28f1"
                                         :created     "Wednesday, September 23, 2015 9:54 AM"
                                         :credit      92748
                                         :debit       95304
                                         :description "Wiring officia qui mollit aute ipsum"
                                         :customerId  "f44ca3aa-1e41-4493-b512-2d609e9d52d4"}
                                        {:id          "7b7cd7cf-85fe-4c5a-85cc-dd7c1c410546"
                                         :created     "Friday, May 22, 2015 9:52 AM"
                                         :credit      48802
                                         :debit       50737
                                         :description "Wiring adipisicing veniam aute ea tempor"
                                         :customer-id "12092bad-6d9f-4d15-8b91-b83b8e386a5c"}
                                        {:id          "0de3178a-f689-4452-be6a-dd8f158aacad"
                                         :created     "Wednesday, December 3, 2014 7:10 AM"
                                         :credit      5503
                                         :debit       54701
                                         :description "Wiring ea in aliqua occaecat excepteur"
                                         :customer-id "688b04e0-fa86-4c3f-a636-35807ce5246a"}
                                        {:id          "c4b5c8a9-c7b1-4550-a83a-d4b9f7321244"
                                         :created     "Wednesday, December 3, 2014 7:10 AM"
                                         :credit      5503
                                         :debit       54701
                                         :description "Wiring ea in aliqua occaecat excepteur"
                                         :customer-id "688b04e0-fa86-4c3f-a636-35807ce5246a"}
                                        ]}
                   {:id                "930cc96c-e0d6-48fe-a957-cf651cfc9e93"
                    :name              :foo-bar-funding
                    :account-type      :real
                    :balance-type      :any
                    :description       "Fund Funding Account"
                    :account-item-data [{:id          "e031f369-ed5b-4746-8605-2e0096bc28f1"
                                         :created     "Wednesday, September 23, 2015 9:54 AM"
                                         :credit      92748
                                         :debit       95304
                                         :description "Wiring officia qui mollit aute ipsum"
                                         :customerId  "f44ca3aa-1e41-4493-b512-2d609e9d52d4"}
                                        {:id          "7b7cd7cf-85fe-4c5a-85cc-dd7c1c410546"
                                         :created     "Friday, May 22, 2015 9:52 AM"
                                         :credit      48802
                                         :debit       50737
                                         :description "Wiring adipisicing veniam aute ea tempor"
                                         :customer-id "12092bad-6d9f-4d15-8b91-b83b8e386a5c"}
                                        {:id          "0de3178a-f689-4452-be6a-dd8f158aacad"
                                         :created     "Wednesday, December 3, 2014 7:10 AM"
                                         :credit      5503
                                         :debit       54701
                                         :description "Wiring ea in aliqua occaecat excepteur"
                                         :customer-id "688b04e0-fa86-4c3f-a636-35807ce5246a"}
                                        {:id          "c4b5c8a9-c7b1-4550-a83a-d4b9f7321244"
                                         :created     "Wednesday, December 3, 2014 7:10 AM"
                                         :credit      5503
                                         :debit       54701
                                         :description "Wiring ea in aliqua occaecat excepteur"
                                         :customer-id "688b04e0-fa86-4c3f-a636-35807ce5246a"}
                                        ]}
                   {:id                "42905257-f109-4b92-b839-610a126b3bbf"
                    :name              :foo-bar-servicing
                    :account-type      :real
                    :balance-type      :any
                    :description       "Fund Servicing Account"
                    :account-item-data [{:id          "e031f369-ed5b-4746-8605-2e0096bc28f1"
                                         :created     "Wednesday, September 23, 2015 9:54 AM"
                                         :credit      92748
                                         :debit       95304
                                         :description "Wiring officia qui mollit aute ipsum"
                                         :customerId  "f44ca3aa-1e41-4493-b512-2d609e9d52d4"}
                                        {:id          "7b7cd7cf-85fe-4c5a-85cc-dd7c1c410546"
                                         :created     "Friday, May 22, 2015 9:52 AM"
                                         :credit      48802
                                         :debit       50737
                                         :description "Wiring adipisicing veniam aute ea tempor"
                                         :customer-id "12092bad-6d9f-4d15-8b91-b83b8e386a5c"}
                                        {:id          "0de3178a-f689-4452-be6a-dd8f158aacad"
                                         :created     "Wednesday, December 3, 2014 7:10 AM"
                                         :credit      5503
                                         :debit       54701
                                         :description "Wiring ea in aliqua occaecat excepteur"
                                         :customer-id "688b04e0-fa86-4c3f-a636-35807ce5246a"}
                                        {:id          "c4b5c8a9-c7b1-4550-a83a-d4b9f7321244"
                                         :created     "Wednesday, December 3, 2014 7:10 AM"
                                         :credit      5503
                                         :debit       54701
                                         :description "Wiring ea in aliqua occaecat excepteur"
                                         :customer-id "688b04e0-fa86-4c3f-a636-35807ce5246a"}]}])


