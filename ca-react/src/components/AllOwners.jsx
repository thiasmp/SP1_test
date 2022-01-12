export default function AllOwners(props) {
    return (
        <div key={props.owner}>
            <table className="table">
                <thead>
                    <tr>
                        <th scope="col">Name</th>
                        <th scope="col">Address</th>
                        <th scope="col">Phone</th>
                    </tr>
                </thead>
                <tbody>
                     {props.owner.map((owner) => (
                    <tr>
                        <td> {owner.name}</td>;
                        <td> {owner.address} </td>;
                        <td> {owner.phone}</td>;
                        </tr>
                        
                    ))}
                    
                    
                     
                </tbody>
            </table>
            
        </div>
        
    )
}