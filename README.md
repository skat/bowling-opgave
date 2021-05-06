# Programmerings opgave

## Bowling-point algoritme

Implementer en algoritme som fortløbende kan beregne summen for et spil, der følger [10-kegle reglerne](https://en.wikipedia.org/wiki/Ten-pin_bowling#Traditional_scoring) til pointberegning i bowling. 

For at løse opgaven skal du bruge to REST API endpoints som midlertidigt tilbydes af SKAT:

<table>
  <tbody>
    <tr>
      <th align="center" width="5%">Method</th>
      <th align="center" width="30%">URL</th>
      <th align="center" width="25%">Parametre</th>
      <th align="center" width="40%">Beskrivelse</th>
    </tr>
    <tr>
      <td valign="top">GET</td>
      <td valign="top">http://13.74.31.101/api/points</td>
      <td valign="top"></td>
      <td>
        <ul>
          <li>Returnerer en JSON-liste med en tilfældig længde og kombination af valide bowling points, samt et token, som skal bruges i POST endpoint.</li>
          <li>Strike er repræsenteret ved [10,0]</li>
          <li>Spare er repræsenteret ved t. ex. [7,3] eller [0,10] eller [5,5]</li>
      </ul>
      </td>
    </tr>
    <tr>
      <td valign="top">POST</td>
      <td valign="top">http://13.74.31.101/api/points</td>
      <td valign="top"><i>token</i>: (string)
        <br />
        YHGgktp8DkUpMsmjmJfsOTJ3PUAxJOBk
        <br /><br />
        <i>points</i>: (array)
        <br />
        [10,16,23,33,48]
        <br />
        <br />
        Eksempel på json body:
        <br />
        {"token": "124jgjfj3FkenI", "points": [5, 10, 25, 30]}
      </td>
      <td valign="top"><i>token</i>: Modtaget i GET<br /><i>points</i>: Dine kalkulerede summer<br /><br />Returnerer HTTP status kode ”200 OK” hvis <i>token</i> er korrekt og JSON { "success": true } hvis <i>summerne</i> er korrekt.<br /><br />Summerne er en liste af de akkumulerende point resultater.<br /><br />T. ex. giver <i>point</i> [[3,7],[10,0],[8,2],[8,1],[10,0],[3,4],[7,0],[5,5],[3,2],[2,5]] <i>summerne</i> [20,40,58,67,84,91,98,111,116,123], hvor 123 er totalsummen efter, i det her tilfælde, 10 omganger. <br /><br /> Tip: Hvis pointene ender på <i>spare / strike</i> før et normal spils længde, så vil der ikke udløses bonus. For eksempel vil [[2, 0], [8, 2]] give <i>summerne</i> [2, 12]</td>
    </tr>
  </tbody>
</table>

## Forudsætninger
* Programmeringssprog: Valgfrit (dog foretrækkes java/grails)
* Løsningsdesign/arkitektur: Valgfrit 
* UI: Valgfrit om nødvendig
* Kildekode skal leveres via URL til kildekode repository på Github
  * Evt. URL til en DockerHub instans, hvor vi kan hente en Docker container med nødvendige afhængigheder for at køre koden. 
* Kildekode skal testes på en passende måde.
* 10-kegle bowling med traditionelle 10-kegle regler. 
  * https://en.wikipedia.org/wiki/Ten-pin_bowling#Traditional_scoring  
  * https://da.wikipedia.org/wiki/Bowling 
  * Simulator: http://www.bowlinggenius.com/ 
